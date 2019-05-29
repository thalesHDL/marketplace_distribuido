package com.sd.marcketplace.model.network;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.util.Util;

import com.sd.marcketplace.model.util.Constantes;

public class ModelChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private JChannel channel;
	private MessageDispatcher despacher;
	
	public ModelChannel() {
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
		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);

		this.despacher = new MessageDispatcher(this.channel, this);

		this.channel.setReceiver(this);
		
		this.channel.connect(Constantes.MODEL_CHANNEL_NAME);
		this.eventLoop();
		this.channel.close();
	}

	private void eventLoop() {
		int t = 1000;
		int t2 = 0;
		while(t2 < t) {
			Util.sleep(1000);
			t2 += 1;
		}
	}

	public void receive(Message msg) {
		System.out.println("" + msg.getSrc() + ": " + msg.getObject());
	}

	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("recebi a mensagem: " + msg.getSrc() + ": " + msg.getObject());
		return msg;
	}

}