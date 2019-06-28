package com.sd.marcketplace.model.server.observer;

import com.sd.marcketplace.model.server.service.ModelService;

public class ModelObserver extends ModelService {
	
	protected void loopModel() {
		try {
			model();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	private void model() throws Exception {	
		while(true) {
			sleep(100);
		}
	}
			
}
