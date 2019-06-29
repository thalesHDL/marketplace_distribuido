package com.sd.marcketplace.model.server.resource;

import com.sd.marcketplace.model.server.observer.ModelObserver;

import comum.domain.Usuario;
import comum.util.HeaderUtil;
import comum.util.PacoteUtil;
import comum.util.communication.Pacote;

public class ModelResource extends ModelObserver {

	// ======== POST
	protected Object modelPostAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== POST ONE
	protected Object modelPostOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPostOneUsuario(Pacote pacote) {
		try {
			Usuario entity = (Usuario) pacote.getContent();
			String operationIdentifier = pacote.getHeader().getToken();
			return modelPostOneUsuario(entity, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}

	// ========== PUT
	protected Object modelPutAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== PUT ONE
	protected Object modelPutOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelPutOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========= DELETE
	protected Object modelDeleteAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// ========== DELETE ONE
	protected Object modelDeleteOneAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelDeleteOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET
	protected Object modelGetAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ONE
	protected Object modelGetOneAddress(Pacote pacote) {
		pacote.setHeader(HeaderUtil.createHeaderRecebido());
		pacote.setContent(modelGetOneAddress());
		return pacote;
	}

	protected Object modelGetOneClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetOneClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetOneUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	// =========== GET ALL
	protected Object modelGetAllAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetAllClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetAllClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetAllUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}
	
	protected Object modelGetAllProduto(Pacote pacote) {
		try {
			String operationIdentifier = pacote.getHeader().getToken();
			return modelGetAllProduto(operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	

	// ========== GET BY FILTER
	protected Object modelGetByFilterAddress(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetByFilterClusterController(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetByFilterClusterModel(Pacote pacote) {
		// TODO: implementar
		return null;
	}

	protected Object modelGetByFilterUsuario(Pacote pacote) {
		// TODO: implementar
		return null;
	}
}
