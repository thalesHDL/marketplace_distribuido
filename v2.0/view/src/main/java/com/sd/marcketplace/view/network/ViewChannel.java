package com.sd.marcketplace.view.network;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;

import com.sd.marcketplace.view.util.Constantes;
import com.sd.marcketplace.view.util.MessageUtil;

import java.util.Scanner;

public class ViewChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private Scanner input;
	private JChannel channel;
	private MessageDispatcher despacher;
	
	
	public ViewChannel() {
		// Empty constructor
	}

	public void run() {
		try {
			startChannel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Função que inicializa a classe, setando o channel e o despacher, e após isto
	 * conectando o chanel a algum canal
	 *
	 * @return void
	 * @param -
	 * @author thales
	 * @version 1.0
	 * @since 2019-05-05
	 **/
	public void startChannel() throws Exception {	
		this.input = new Scanner(System.in);
		
		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);

		this.despacher = new MessageDispatcher(this.channel, this);

		this.channel.setReceiver(this);
		
		this.channel.connect(Constantes.VIEW_CHANNEL_NAME);
		this.eventLoop();
		this.channel.close();
	}
	
	private void eventLoop() throws Exception {
		int opcao = 0;
		while (opcao != Constantes.SAIR) {
			System.out.print(MessageUtil.menuOptions());
			opcao = Integer.parseInt(this.input.next());
			trataEscolha(opcao);
		}
		this.input.close();
	}
	
	private void cadastrarProduto(String nomeProduto) throws Exception {
		this.channel.connect(Constantes.MODEL_CHANNEL_NAME);
		
		Message message = new Message(null, "put produto ".concat(nomeProduto));
		
		enviaMulticast(message);
	}
	
	private void enviaMulticast(Message msg) throws Exception {
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
		
        this.despacher.castMessage(null, msg, opcoes);
        
        System.out.println("Enviado comando para cadastrar produto : ".concat(msg.getObject().toString()));
	}
	
	private void trataEscolha(int acao) throws Exception {
		if(acao == Constantes.CADASTRAR) {
			System.out.print(MessageUtil.messageCadastrarProduto());
			String nomeProduto = this.input.next();
			this.cadastrarProduto(nomeProduto);
		}
	}
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
