package com.sd.marcketplace.controller.server.service;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.controller.server.manager.ControllerManager;

import comum.domain.Usuario;

import comum.util.communication.Pacote;

public class ControllerService extends ControllerManager {
			
	protected Address controllerGetOneAddress() {
		return controllerChannel.getAddress();
	}
	
	protected void controllerDeleteOneClusterModel(Address addr) {
		clusterModel.remove(addr);
	}
	
	protected void controllerPutClusterModel(List<Address> membersNodeModelo) {
		updateClusterModel(membersNodeModelo);
	}
	
	protected Pacote controllerPostOneUsuario(Usuario usuario) throws Exception {
		return modelPostOneUsuario(usuario);
	}
	
	protected Pacote controllerGetAllProduto() throws Exception {
		return modelGetAllProduto();
	}
	
	
	
}
