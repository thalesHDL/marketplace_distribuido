package com.sd.marcketplace.view.channel;

import com.sd.marcketplace.view.channel.service.ControllerService;
import com.sd.marcketplace.view.comum.enumerate.Action;
import com.sd.marcketplace.view.comum.enumerate.Entidade;
import com.sd.marcketplace.view.comum.enumerate.Status;
import com.sd.marcketplace.view.comum.objeto.SharedObject;

public class ControllerChannel extends ControllerService {
	
	public ControllerChannel() {
		// Empty constructor
	}
	
	public void startChannel(SharedObject share) throws Exception {
		this.share = share;
		this.initChannel(CONTROLLER_CHANNEL);
	}
	
	@Override
	public void eventLoop() throws Exception {
		System.out.println("START LOOP");
		// enviar esses addres pros otos do controle de verdade
		while(true) {
			if(this.share.getStatus().equals(Status.NOTIFY_CONTROLE)) {
				trataRequest();
			}
			sleep(5000);
		}
	}
	
	
	public void trataRequest() {
		if (this.share.getObj().getAcao().equals(Action.POST)) {
			trataPost();
		}
	}
	
	public void trataPost() {
		if (this.share.getObj().getEntidade().equals(Entidade.USUARIO)) {
			trataPostUsuario();
		}
	}
	
	public void trataPostUsuario() {
		
	}
	
	


}
