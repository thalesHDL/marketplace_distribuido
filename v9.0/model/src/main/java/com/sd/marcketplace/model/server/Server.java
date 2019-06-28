package com.sd.marcketplace.model.server;

import com.sd.marcketplace.model.server.receiver.ModelReceiver;

public class Server extends ModelReceiver {
	
	public void init() {
		initModel();
		start();
	}
	
	private void start() {
		loopModel();
		desconnectModel();
	}

}
