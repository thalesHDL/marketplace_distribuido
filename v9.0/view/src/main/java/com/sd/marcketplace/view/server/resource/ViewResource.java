package com.sd.marcketplace.view.server.resource;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.view.server.observer.ViewObserver;

import comum.util.Util;
import comum.util.communication.Pacote;

@SuppressWarnings("unchecked")
public class ViewResource extends ViewObserver {
	
	// ======== POST
	protected Object viewPostAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== POST ONE
	protected Object viewPostOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPostOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== PUT
	protected Object viewPutAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPutClusterController(Pacote pacote) {
		List<Address> membersNodeController = (List<Address>) pacote.getContent();
		viewPutClusterController(membersNodeController);
		Util.print("Cluster: " + clusterController.toString());
		return null;
	}

	protected Object viewPutClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPutUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== PUT ONE
	protected Object viewPutOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPutOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPutOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewPutOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========= DELETE
	protected Object viewDeleteAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewDeleteClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewDeleteClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewDeleteUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== DELETE ONE
	protected Object viewDeleteOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewDeleteOneClusterController(Pacote pacote) {
		Address memberClusterController = (Address) pacote.getContent();
		viewDeleteOneClusterController(memberClusterController);
		Util.print("Cluster: " + clusterController.toString());
		return null;
	}

	protected Object viewDeleteOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewDeleteOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET
	protected Object viewGetAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ONE
	protected Object viewGetOneAddress(Pacote pacote) {
		// retorna null pois se deseja saber o address dos viewo, e este esta no
		// controller
		return null;
	}

	protected Object viewGetOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ALL
	protected Object viewGetAllAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetAllClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetAllClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetAllUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== GET BY FILTER
	protected Object viewGetByFilterAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetByFilterClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetByFilterClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object viewGetByFilterUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

}
