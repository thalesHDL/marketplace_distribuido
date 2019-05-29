package com.sd.marcketplace.view.network;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;

import com.sd.marcketplace.view.network.message.SharedMessage;
import com.sd.marcketplace.view.network.message.enumerate.Action;
import com.sd.marcketplace.view.util.Constantes;

public class ModelChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private JChannel channel;
	private MessageDispatcher despacher;
	private SharedMessage sharedMessage;
	
	public ModelChannel() {
		// Empty constructor
	}
	
	public ModelChannel(SharedMessage sharedMessage) {
		this.sharedMessage = sharedMessage;
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
		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);

		this.despacher = new MessageDispatcher(this.channel, this);

		this.channel.setReceiver(this);
		
		this.channel.connect(Constantes.MODEL_CHANNEL_NAME);
		this.eventLoop();
		this.channel.close();
	}
	
	public void eventLoop() {
		int t = 0;
		int t2 = 1;
		while(t != t2) {
			if(!this.sharedMessage.getAction().equals(Action.NONE)) {
				System.out.println("acao diferente de NONE");
				this.trataRequest();
			}
			sleep(1000);
		}
	}
	
	private void trataRequest() {
		if(this.sharedMessage.getAction().equals(Action.POST)) {
			System.out.println("acao: POST");
			this.cadastrarProduto();
		}
	}
	
	private void cadastrarProduto() {
		try {
			System.out.println("ModelChannel - cadastrarProduto");
			this.enviaMulticast(new Message(null, this.sharedMessage.getContent()));
			this.sharedMessage.finishAction();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private void enviaMulticast(Message msg) throws Exception {
		RequestOptions opcoes = new RequestOptions(); 
        opcoes.setMode(ResponseMode.GET_ALL);
        opcoes.setAnycasting(false);
        this.despacher.castMessage(null, msg, opcoes);        
	}
	
	private static void sleep(int time) {
		try {
			Thread.currentThread();
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void receive(Message msg) {
		System.out.println("prepatando pra enviar: " + msg.getSrc() + ": " + msg.getObject());
	}

}
