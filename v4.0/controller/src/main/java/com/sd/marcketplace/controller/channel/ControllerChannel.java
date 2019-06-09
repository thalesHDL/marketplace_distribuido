package com.sd.marcketplace.controller.channel;

import com.sd.marcketplace.controller.channel.service.ControllerService;
import com.sd.marcketplace.controller.comum.enumerate.Status;
import com.sd.marcketplace.controller.comum.objeto.SharedObject;

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
			if(this.share.getStatus().equals(Status.READY)) {
				
			}
			sleep(5000);
		}
	}

}
