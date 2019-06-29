package com.sd.marcketplace.view.server.service;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.view.server.manager.ViewManager;

public class ViewService extends ViewManager {

	protected void viewDeleteOneClusterController(Address addr) {
		clusterController.remove(addr);
	}
	
	protected void viewPutClusterController(List<Address> membersNodeConttroller) {
		updateClusterController(membersNodeConttroller);
	}

}
