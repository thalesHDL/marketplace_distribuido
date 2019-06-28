package com.sd.marcketplace.view.server.observer;

import com.sd.marcketplace.view.server.service.ControllerService;

public class ControllerObserver extends ControllerService {
	
	protected void loopController() {
		try {
			controller();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	private void controller() throws InterruptedException {
		while(true) {
			sleep(100);
		}
	}

}
