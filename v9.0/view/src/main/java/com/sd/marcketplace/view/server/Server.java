package com.sd.marcketplace.view.server;

import com.sd.marcketplace.view.server.receiver.ViewReceiver;

public class Server extends ViewReceiver {
	
	public void init() {
		initVariaveis();
		initView();
		initController();
		start();
	}
	
	private void start() {
		loopView();
		desconnectView();
		desconnectController();
	}

}
