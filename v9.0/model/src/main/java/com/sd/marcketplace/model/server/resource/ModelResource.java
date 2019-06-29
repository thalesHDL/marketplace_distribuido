package com.sd.marcketplace.model.server.resource;

import com.sd.marcketplace.model.server.observer.ModelObserver;

import comum.domain.Anuncio;
import comum.domain.Comentario;
import comum.domain.Usuario;
import comum.domain.Venda;
import comum.util.HeaderUtil;
import comum.util.PacoteUtil;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
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
			
			Usuario result = modelPostOneUsuario(entity);
			
			String operationIdentifier = pacote.getHeader().getToken();
			Pacote operation = new Pacote(Operation.DELETE_ONE, Entidade.USUARIO, result.getId());
			addOperation(operationIdentifier, operation);
			
			return PacoteUtil.createPacoteRecebido(result, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	protected Object modelPostOneAnuncio(Pacote pacote) {
		try {
			Anuncio entity = (Anuncio) pacote.getContent();
			
			Anuncio result = modelPostOneAnuncio(entity);
			
			String operationIdentifier = pacote.getHeader().getToken();
			Pacote operation = new Pacote(Operation.DELETE_ONE, Entidade.ANUNCIO, result.getId());
			addOperation(operationIdentifier, operation);
			
			return PacoteUtil.createPacoteRecebido(result, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	protected Object modelPostOneComentario(Pacote pacote) {
		try {
			Comentario entity = (Comentario) pacote.getContent();
			
			Comentario result = modelPostOneComentario(entity);
			
			String operationIdentifier = pacote.getHeader().getToken();
			Pacote operation = new Pacote(Operation.DELETE_ONE, Entidade.COMENTARIO, result.getId());
			addOperation(operationIdentifier, operation);
			
			return PacoteUtil.createPacoteRecebido(result, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	protected Object modelPostOneVenda(Pacote pacote) {
		try {
			Venda entity = (Venda) pacote.getContent();
			
			Venda result = modelPostOneVenda(entity);
			
			String operationIdentifier = pacote.getHeader().getToken();
			Pacote operation = new Pacote(Operation.DELETE_ONE, Entidade.VENDA, result.getId());
			addOperation(operationIdentifier, operation);
			
			return PacoteUtil.createPacoteRecebido(result, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError(e.getMessage(), pacote.getHeader().getToken());
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
		try {
			Long id = (Long) pacote.getContent();
			Usuario result = modelDeleteOneUsuario(id);
			
			String operationIdentifier = pacote.getHeader().getToken();
			Pacote operation = new Pacote(Operation.POST_ONE, Entidade.USUARIO, result);
			addOperation(operationIdentifier, operation);
			return PacoteUtil.createPacoteRecebido(result, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
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
	
	protected Object modelGetOneAnuncio(Pacote pacote) {
		try {
			String operationIdentifier = pacote.getHeader().getToken();
			Long id = (Long) pacote.getContent();
			return modelGetOneAnuncio(id, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
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
		try {
			String operationIdentifier = pacote.getHeader().getToken();
			Usuario filter = (Usuario) pacote.getContent();
			return modelGetByFilterUsuario(filter, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	protected Object modelGetByFilterAnuncio(Pacote pacote) {
		try {
			String operationIdentifier = pacote.getHeader().getToken();
			Anuncio filter = (Anuncio) pacote.getContent();
			return modelGetByFilterAnuncio(filter, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
	protected Object modelGetByFilterComentario(Pacote pacote) {
		try {
			String operationIdentifier = pacote.getHeader().getToken();
			Comentario filter = (Comentario) pacote.getContent();
			return modelGetByFilterComentario(filter, operationIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return PacoteUtil.createPacoteError("Houve um problema ao executar esta operação, por favor tente novamente masi tarde", pacote.getHeader().getToken());
		}
	}
	
}
