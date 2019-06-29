package com.sd.marcketplace.model.server.receiver;

import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;

import com.sd.marcketplace.model.server.resource.ModelResource;

import comum.util.PacoteUtil;
import comum.util.Util;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;

public class ModelReceiver extends ModelResource {

	protected ModelReceiver() {
		// Empty constructor
	}
	
	protected void initModel() {
		initChannelModel();
		initModelDispatcher();
		initModelMembershipListner();
		connectModel();
	}
	
	protected void initModelDispatcher() {
		modelDispatcher = new MessageDispatcher(modelChannel, this);
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
		if (classe.equals(Classe.MODELO)) {
			Util.print("MODELO");
			return handleModel(pacote);
		}
		return null;
	}
	
	protected Object handleModel(Pacote pacote) throws Exception {
		return modelAnaliseOperacao(pacote);
	}
	
	protected Object modelAnaliseOperacao(Pacote pacote) {
		Operation operacao = pacote.getOperacao();
		Util.print(operacao);
		if (operacao.equals(Operation.POST)) {
			return modelAnalisePost(pacote);
		} else if (operacao.equals(Operation.POST_ONE)) {
			return modelAnalisePostOne(pacote);
		} else if (operacao.equals(Operation.PUT)) {
			return modelAnalisePut(pacote);
		} else if (operacao.equals(Operation.PUT_ONE)) {
			return modelAnalisePutOne(pacote);
		} else if (operacao.equals(Operation.DELETE)) {
			return modelAnaliseDelete(pacote);
		} else if (operacao.equals(Operation.DELETE_ONE)) {
			return modelAnaliseDeleteOne(pacote);
		} else if (operacao.equals(Operation.GET)) {
			return modelAnaliseGet(pacote);
		} else if (operacao.equals(Operation.GET_ONE)) {
			return modelAnaliseGetOne(pacote);
		} else if (operacao.equals(Operation.GET_ALL)) {
			return modelAnaliseGetAll(pacote);
		} else if (operacao.equals(Operation.GET_BY_FILTER)) {
			return modelAnaliseGetByFilter(pacote);
		}
		return null;
	}
	
	protected Object modelAnalisePost(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelPostAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelPostClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelPostClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelPostUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnalisePostOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelPostOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelPostOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelPostOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelPostOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnalisePut(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelPutAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelPutClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelPutClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelPutUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnalisePutOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelPutOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelPutOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelPutOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelPutOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseDelete(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelDeleteAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelDeleteClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelDeleteClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelDeleteUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseDeleteOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelDeleteOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelDeleteOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelDeleteOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelDeleteOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseGet(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelGetAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelGetClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelGetClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelGetUsuario(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseGetOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelGetOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelGetOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelGetOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelGetOneUsuario(pacote);
		} else if (entidade.equals(Entidade.ANUNCIO)) {
			return modelGetOneAnuncio(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseGetAll(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelGetAllAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelGetAllClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelGetAllClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelGetAllUsuario(pacote);
		} else if (entidade.equals(Entidade.PRODUTO)) {
			return modelGetAllProduto(pacote);
		}
		return null;
	}
	
	protected Object modelAnaliseGetByFilter(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return modelGetByFilterAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return modelGetByFilterClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return modelGetByFilterClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return modelGetByFilterUsuario(pacote);
		} else if (entidade.equals(Entidade.ANUNCIO)) {
			return modelGetByFilterAnuncio(pacote);
		}
		return null;
	}
}
