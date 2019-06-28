package com.sd.marcketplace.controller.server;

import com.sd.marcketplace.controller.server.receiver.ControllerReceiver;

public class Server extends ControllerReceiver {
	
	public void init() {
		initVariaveis();
		initController();
		initModel();
		start();
	}
	
	private void start() {
		loopController();
		desconnectController();
		desconnectModel();
	}

}
