package com.sd.marcketplace.controller.server.receiver;

import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;

import com.sd.marcketplace.controller.server.resource.ControllerResource;

import comum.util.PacoteUtil;
import comum.util.Util;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;

public class ControllerReceiver extends ControllerResource {

	protected ControllerReceiver() {
		// Empty constructor
	}
	
	protected void initController() {
		initChannelController();
		initControllerDispatcher();
		initControllerMembershipListner();
		connectController();
	}
	
	protected void initControllerDispatcher() {
		controllerDispatcher = new MessageDispatcher(controllerChannel, this);
	}
	
	@Override
	public Object handle(Message msg) throws Exception {
		try {
			return analiseMensagem(msg);
		} catch (Exception e) {
			return PacoteUtil.createPacoteError(e.getMessage());
		}
		
	}
	
	protected Object analiseMensagem(Message msg) throws Exception {
		try {
			Pacote pacote = (Pacote) msg.getObject();
			Util.print(pacote.toString());
			return analiseClasse(pacote);
		} catch (Exception e) {
			throw new Exception("Não foi possível das o cast no pacote, Conteudo invalido");
		}
	}
	
	protected Object analiseClasse(Pacote pacote) throws Exception {
		Classe classe = pacote.getClasse();
		if (classe.equals(Classe.CONTROLE)) {
			Util.print("CONTROLE");
			return handleController(pacote);
		} else if (classe.equals(Classe.MODELO)) {
			Util.print("MODELO");
			return handleModel(pacote);
		}
		return null;
	}
	
	protected Object handleController(Pacote pacote) throws Exception {
		return controllerAnaliseOperacao(pacote);
	}
	
	protected Object controllerAnaliseOperacao(Pacote pacote) {
		Operation operacao = pacote.getOperacao();
		Util.print(operacao);
		if (operacao.equals(Operation.POST)) {
			return controllerAnalisePost(pacote);
		} else if (operacao.equals(Operation.POST_ONE)) {
			return controllerAnalisePostOne(pacote);
		} else if (operacao.equals(Operation.PUT)) {
			return controllerAnalisePut(pacote);
		} else if (operacao.equals(Operation.PUT_ONE)) {
			return controllerAnalisePutOne(pacote);
		} else if (operacao.equals(Operation.DELETE)) {
			return controllerAnaliseDelete(pacote);
		} else if (operacao.equals(Operation.DELETE_ONE)) {
			return controllerAnaliseDeleteOne(pacote);
		} else if (operacao.equals(Operation.GET)) {
			return controllerAnaliseGet(pacote);
		} else if (operacao.equals(Operation.GET_ONE)) {
			return controllerAnaliseGetOne(pacote);
		} else if (operacao.equals(Operation.GET_ALL)) {
			return controllerAnaliseGetAll(pacote);
		} else if (operacao.equals(Operation.GET_BY_FILTER)) {
			return controllerAnaliseGetByFilter(pacote);
		}
		return null;
	}
	
	protected Object controllerAnalisePost(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerPostAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerPostClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerPostClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerPostUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnalisePostOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerPostOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerPostOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerPostOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerPostOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnalisePut(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerPutAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerPutClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerPutClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerPutUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnalisePutOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerPutOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerPutOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerPutOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerPutOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnaliseDelete(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerDeleteAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerDeleteClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerDeleteClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerDeleteUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnaliseDeleteOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerDeleteOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerDeleteOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerDeleteOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerDeleteOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnaliseGet(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerGetAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerGetClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerGetClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerGetUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnaliseGetOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerGetOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerGetOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerGetOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerGetOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object controllerAnaliseGetAll(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerGetAllAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerGetAllClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerGetAllClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerGetAllUsuario(pacote);
		} else if (entidade.equals(Entidade.PRODUTO)) {
			return controllerGetAllProduto(pacote);
		}
		
		return null;
	}
	
	protected Object controllerAnaliseGetByFilter(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return controllerGetByFilterAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return controllerGetByFilterClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return controllerGetByFilterClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return controllerGetByFilterUsuario(pacote);
		}
		return null;
	}
}
