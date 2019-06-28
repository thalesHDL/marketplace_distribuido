package com.sd.marcketplace.view.server.receiver;

import org.jgroups.Message;
import org.jgroups.blocks.MessageDispatcher;

import com.sd.marcketplace.view.server.resource.ViewResource;

import comum.util.PacoteUtil;
import comum.util.Util;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;

public class ViewReceiver extends ViewResource {

	protected ViewReceiver() {
		// Empty constructor
	}
	
	protected void initView() {
		initChannelView();
		initViewDispatcher();
		initViewMembershipListner();
		connectView();
	}
	
	protected void initViewDispatcher() {
		viewDispatcher = new MessageDispatcher(viewChannel, this);
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
		if (classe.equals(Classe.VISAO)) {
			Util.print("VISAO");
			return handleView(pacote);
		} else if (classe.equals(Classe.CONTROLE)) {
			Util.print("CONTROLE");
			return handleController(pacote);
		}
		return null;
	}
	
	protected Object handleView(Pacote pacote) throws Exception {
		return viewAnaliseOperacao(pacote);
	}

	protected Object viewAnaliseOperacao(Pacote pacote) {
		Operation operacao = pacote.getOperacao();
		Util.print(operacao);
		if (operacao.equals(Operation.POST)) {
			return viewAnalisePost(pacote);
		} else if (operacao.equals(Operation.POST_ONE)) {
			return viewAnalisePostOne(pacote);
		} else if (operacao.equals(Operation.PUT)) {
			return viewAnalisePut(pacote);
		} else if (operacao.equals(Operation.PUT_ONE)) {
			return viewAnalisePutOne(pacote);
		} else if (operacao.equals(Operation.DELETE)) {
			return viewAnaliseDelete(pacote);
		} else if (operacao.equals(Operation.DELETE_ONE)) {
			return viewAnaliseDeleteOne(pacote);
		} else if (operacao.equals(Operation.GET)) {
			return viewAnaliseGet(pacote);
		} else if (operacao.equals(Operation.GET_ONE)) {
			return viewAnaliseGetOne(pacote);
		} else if (operacao.equals(Operation.GET_ALL)) {
			return viewAnaliseGetAll(pacote);
		} else if (operacao.equals(Operation.GET_BY_FILTER)) {
			return viewAnaliseGetByFilter(pacote);
		}
		return null;
	}
	
	protected Object viewAnalisePost(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewPostAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewPostClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewPostClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewPostUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnalisePostOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewPostOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewPostOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewPostOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewPostOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnalisePut(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewPutAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewPutClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewPutClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewPutUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnalisePutOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewPutOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewPutOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewPutOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewPutOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseDelete(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewDeleteAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewDeleteClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewDeleteClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewDeleteUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseDeleteOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewDeleteOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewDeleteOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewDeleteOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewDeleteOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseGet(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewGetAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewGetClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewGetClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewGetUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseGetOne(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewGetOneAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewGetOneClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewGetOneClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewGetOneUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseGetAll(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewGetAllAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewGetAllClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewGetAllClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewGetAllUsuario(pacote);
		}
		return null;
	}
	
	protected Object viewAnaliseGetByFilter(Pacote pacote) {
		Entidade entidade = pacote.getEntidade();
		Util.print(entidade);
		if (entidade.equals(Entidade.ADDRESS)) {
			return viewGetByFilterAddress(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_CONTROLE)) {
			return viewGetByFilterClusterController(pacote);
		} else if (entidade.equals(Entidade.CLUSTER_MODELO)) {
			return viewGetByFilterClusterModel(pacote);
		} else if (entidade.equals(Entidade.USUARIO)) {
			return viewGetByFilterUsuario(pacote);
		}
		return null;
	}

}
