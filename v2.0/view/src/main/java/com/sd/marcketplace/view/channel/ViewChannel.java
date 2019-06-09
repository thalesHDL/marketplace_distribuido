package com.sd.marcketplace.view.channel;

import java.util.Scanner;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestOptions;

import com.sd.marcketplace.view.handler.ViewHandler;
import com.sd.marcketplace.view.receiver.ViewReceiver;
import com.sd.marcketplace.view.util.Constantes;
import com.sd.marcketplace.view.util.MessageUtil;

public class ViewChannel {	
	
//	private static final int INDEX_COORDENADOR = 0;
//	private static final long TIMEOUT_RESPONSE = 30000;
//	private boolean isCoordenador = false;
//	
//	private JChannel channel;
//	private MessageDispatcher despacher;
//	private SharedMessage sharedMessage;
//	
//	
//	public ViewChannel() {
//		// Empty constructor
//	}
//	
//	public ViewChannel(SharedMessage sharedMessage) {
//		this.sharedMessage = sharedMessage;
//	}
//
//	public void run() {
//		try {
//			this.startChannel();
//		} catch (Exception e) {
//			e.printStackTrace();
//			Thread.currentThread().interrupt();
//		}
//	}
//	
//	/**
//	 * Função que inicializa a classe, setando o channel e o despacher, e após isto
//	 * conectando o chanel a algum canal
//	 *
//	 * @return void
//	 * @param -
//	 * @author thales
//	 * @version 1.0
//	 * @since 2019-05-05
//	 **/
//	private void startChannel() throws Exception {	
//		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);
//
//		this.despacher = new MessageDispatcher(this.channel, this);
//
//		this.channel.setReceiver(this);
//		
//		this.channel.connect(Constantes.VIEW_CHANNEL_NAME);
//		this.verificaCoordenador();
//		this.eventLoop();
//		this.channel.close();
//	}
//	
//	private void eventLoop() throws Exception {
//		Scanner input = new Scanner(System.in);
//		int opcao = 0;
//		while (opcao != Constantes.SAIR) {
//			System.out.print(MessageUtil.menuOptions());
//			opcao = Integer.parseInt(input.next());
//			trataEscolha(opcao, input);
//		}
//		input.close();
//	}
//	
//	
//	
//	private Address getCoordenador() {
//		return this.channel.getView().getMembers().get(INDEX_COORDENADOR);
//	}
//	
//	private void trataEscolha(int acao, Scanner input) throws Exception {
//		if(acao == Constantes.CADASTRAR) {
//			System.out.print(MessageUtil.messageCadastrarProduto());
//			String nomeProduto = input.next();
//			this.cadastrarProduto(nomeProduto);
//		}
//	}
//	
//	private void cadastrarProduto(String nomeProduto) throws Exception {
//		if(this.isCoordenador) {
//			this.sharedMessage.initCadastrarProduto(nomeProduto);
//		} else {
//			Message msg = new Message(getCoordenador(), new SharedMessage(Action.POST, nomeProduto));
//			RequestOptions opts = new RequestOptions(ResponseMode.GET_FIRST, TIMEOUT_RESPONSE); 
//			Object resp = this.despacher.sendMessage(msg, opts);
//			System.out.println("[VIEW] retorno unicast: ".concat(resp.toString()));
//		}
//	}
//	
//	private void verificaCoordenador() {
//		Address coordenadorAddress = this.channel.getView().getMembers().get(INDEX_COORDENADOR);
//		Address localAddress = this.channel .getAddress();
//		if(localAddress.equals(coordenadorAddress)) {
//			this.isCoordenador = true;
//			new Thread(new ModelChannel(this.sharedMessage)).start();
//		} else {
//			this.isCoordenador = false;
//		}
//	}
//
//
//
//	public Object handle(Message msg) throws Exception {
//		System.out.println("[VIEW] handle message: " + "("+ msg.getSrc() + ") - " + msg.getObject());
//		SharedMessage content = (SharedMessage) msg.getObject();
//		verificaCoordenador();
//		this.cadastrarProduto((String)content.getContent());
//		return true;
//	}
//
//	public void receive(Message msg) {
//		System.out.println("[VIEW] receive message: " + "(" + msg.getSrc() + ") - " + msg.getObject());
//	}
//	
//	public void viewAccepted(View view) {
//		System.out.println("[VIEW] nova View do cluster: " + view);
//		verificaCoordenador();
//	}
	
	
	
	
	
	
	private static final int INDEX_COORDENADOR = 0;
	
	private JChannel channel;
	private MessageDispatcher despacher;
	private ViewReceiver receiver;
	private ViewHandler handler;
	
	String user_name=System.getProperty("user.name", "n/a");

	public ViewChannel() {
		// Empty constructor
	}

	/**
	 * Função que inicializa a classe, setando o channel e o despacher, e após isto
	 * conectando o chanel a algum canal
	 *
	 * @return void
	 * @param -
	 * @author thales
	 * @version 1.0
	 * @throws Exception 
	 * @since 2019-05-05
	 **/
	public void startChannel() throws Exception {
		this.receiver = new ViewReceiver();
		this.handler = new ViewHandler();
		this.channel = new JChannel();
		this.despacher = new MessageDispatcher(this.channel, this.handler);
		this.channel.setReceiver(this.receiver);
		this.channel.connect(Constantes.VIEW_CHANNEL_NAME);
		this.eventLoop();
		this.channel.close();
	}
	
	private void eventLoop() throws Exception {
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		while (opcao != Constantes.SAIR) {
			System.out.print(MessageUtil.menuOptions());
			opcao = Integer.parseInt(input.next());
			trataEscolha(opcao, input);
		}
		input.close();
    }
	
	
	
	
	
	private void trataEscolha(int acao, Scanner input) throws Exception {
		if(acao == Constantes.CADASTRAR) {
			System.out.print(MessageUtil.messageCadastrarProduto());
			String nomeProduto = input.next();
			this.cadastrarProduto(nomeProduto);
		}
	}
	
	private void cadastrarProduto(String nomeProduto) throws Exception {
		Address coordenador = this.getCoordenador();
		Address current = this.getCurrentAddress();
		
		if(coordenador.equals(current)) {
			// envia mensagem
		} else {
			// envia para o coordenador
		}
	}
	
	
	private Address getCoordenador() {
		return this.channel.getView().getMembers().get(INDEX_COORDENADOR);
	}
	
	private Address getCurrentAddress() {
		return this.channel.getAddress();
	}
	
	
	
	
	
	
	
	
	
	
	

}
