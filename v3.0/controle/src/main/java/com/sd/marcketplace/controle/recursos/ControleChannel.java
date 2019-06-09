package com.sd.marcketplace.controle.recursos;

import org.jgroups.JChannel;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Status;
import com.sd.marcketplace.controle.comum.objeto.SharedObject;
import com.sd.marcketplace.controle.recursos.servico.ControleServico;


public class ControleChannel extends ControleServico {
	
	private static final String CANAL_CONTROLE = "ControleChannel";
	
	private JChannel channel;
	
	public ControleChannel() {
		// Empty constructor
	}
	
	public void initChannel(SharedObject sharedObj) throws Exception {	
		this.sharedObj = sharedObj;
		
		this.channel = new JChannel();
		
		initHandler(this.channel);
		
		this.channel.connect(CANAL_CONTROLE);
		this.eventLoop();
		this.channel.close();
	}
	
	private void eventLoop() throws Exception {
		if(this.channel.getView().getMembers().get(0).equals(this.channel.getAddress())) {
			new VisaoChannel().initChannel(this.sharedObj);
		}
		
		while (true) {
			if (this.sharedObj.getStatus().equals(Status.NOTIFY_CONTROLE)) {
				
			}
			sleep(10);
		}
	}
	

}
