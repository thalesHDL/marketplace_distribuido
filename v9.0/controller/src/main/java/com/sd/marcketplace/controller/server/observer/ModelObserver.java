package com.sd.marcketplace.controller.server.observer;

import com.sd.marcketplace.controller.server.service.ModelService;

public class ModelObserver extends ModelService {
	
	protected void loopModel() {
		try {
			model();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	private void model() throws InterruptedException {
		while(true) {
			sleep(100);
		}
	}

}
