package com.sd.marcketplace.entrega.channel;

import java.time.LocalDate;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;

import com.sd.marcketplace.entrega.domain.Anuncio;
import com.sd.marcketplace.entrega.form.Menu;

public class Channel extends ReceiverAdapter implements RequestHandler {
	
	private static final String CANAL_NAME = "Marcketplace";
	
	private JChannel channel;
	private MessageDispatcher dispacher;
	private Menu menu;
	
	
	public Channel() {
		// Empty constructor
	}
	
	public void startChannel() throws Exception {
		this.menu = new Menu();
		this.channel = new JChannel();
		this.dispacher = new MessageDispatcher(this.channel, null, null, this);
		this.channel.connect(CANAL_NAME);
		this.eventLoop();
		this.channel.close();
	}
	
	public void eventLoop() {
		while(true) {
			int escolha = this.menu.getEscolha();
		}
	}
	
	

	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
