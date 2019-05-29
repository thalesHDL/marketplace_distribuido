package com.sd.marcketplace.view.network;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;

import com.sd.marcketplace.view.network.message.SharedMessage;
import com.sd.marcketplace.view.util.Constantes;
import com.sd.marcketplace.view.util.MessageUtil;

import java.util.Scanner;

public class ViewChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private JChannel channel;
	private MessageDispatcher despacher;
	private SharedMessage sharedMessage;
	
	
	public ViewChannel() {
		// Empty constructor
	}
	
	public ViewChannel(SharedMessage sharedMessage) {
		this.sharedMessage = sharedMessage;
	}

	public void run() {
		try {
			this.eventLoop();
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
		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);

		this.despacher = new MessageDispatcher(this.channel, this);

		this.channel.setReceiver(this);
		
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
	
	private void cadastrarProduto(String nomeProduto) throws Exception {
		System.out.println("ViewChannel - cadastrarProduto");
		this.sharedMessage.initCadastrarProduto(nomeProduto);
	}
	
	private void trataEscolha(int acao, Scanner input) throws Exception {
		if(acao == Constantes.CADASTRAR) {
			System.out.print(MessageUtil.messageCadastrarProduto());
			String nomeProduto = input.next();
			this.cadastrarProduto(nomeProduto);
		}
	}
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
