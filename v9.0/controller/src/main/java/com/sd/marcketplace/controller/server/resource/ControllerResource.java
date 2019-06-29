package com.sd.marcketplace.controller.server.resource;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.controller.server.observer.ControllerObserver;

import comum.domain.Usuario;
import comum.util.HeaderUtil;
import comum.util.PacoteUtil;
import comum.util.Util;
import comum.util.communication.Pacote;

@SuppressWarnings("unchecked")
public class ControllerResource extends ControllerObserver {

	// ======== POST
	protected Object controllerPostAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== POST ONE
	protected Object controllerPostOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPostOneUsuario(Pacote pacote) {
		try {
			Usuario usuario = (Usuario) pacote.getContent();
			return controllerPostOneUsuario(usuario);
		} catch (Exception e) {
			Util.print(e.getMessage());
			return PacoteUtil.createPacoteError(e.getMessage());
		}
	}

	// ========== PUT
	protected Object controllerPutAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPutClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPutClusterModel(Pacote pacote) {
		List<Address> membersNodeModelo = (List<Address>) pacote.getContent();
		controllerPutClusterModel(membersNodeModelo);
		Util.print("Cluster: " + clusterModel.toString());
		return null;
	}

	protected Object controllerPutUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== PUT ONE
	protected Object controllerPutOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPutOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPutOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerPutOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========= DELETE
	protected Object controllerDeleteAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerDeleteClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerDeleteClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerDeleteUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== DELETE ONE
	protected Object controllerDeleteOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerDeleteOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerDeleteOneClusterModel(Pacote pacote) {
		Address membersClusterModel = (Address) pacote.getContent();
		controllerDeleteOneClusterModel(membersClusterModel);
		Util.print("Cluster: " + clusterModel.toString());
		return null;
	}

	protected Object controllerDeleteOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET
	protected Object controllerGetAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ONE
	protected Object controllerGetOneAddress(Pacote pacote) {
		pacote.setHeader(HeaderUtil.createHeaderRecebido());
		pacote.setContent(controllerGetOneAddress());
		return pacote;
	}

	protected Object controllerGetOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ALL
	protected Object controllerGetAllAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetAllClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetAllClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetAllUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}
	
	protected Object controllerGetAllProduto(Pacote pacote){
		try {
			return modelGetAllProduto();
		} catch (Exception e) {
			return PacoteUtil.createPacoteError(e.getMessage());
		}
	}

	// ========== GET BY FILTER
	protected Object controllerGetByFilterAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetByFilterClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetByFilterClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object controllerGetByFilterUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}
}
