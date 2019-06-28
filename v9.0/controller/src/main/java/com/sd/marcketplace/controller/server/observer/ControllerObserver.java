package com.sd.marcketplace.controller.server.observer;

import com.sd.marcketplace.controller.server.service.ControllerService;

public class ControllerObserver extends ControllerService {
	
	protected void loopController() {
		try {
			controller();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	private void controller() throws Exception {	
		while(true) {
			sleep(100);
		}
	}
			
}
