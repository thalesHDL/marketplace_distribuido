package com.sd.marcketplace.controller.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.Rsp;
import org.jgroups.util.RspList;

import com.sd.marcketplace.controller.server.manager.ModelManager;

import comum.domain.Anuncio;
import comum.domain.Comentario;
import comum.domain.Usuario;
import comum.domain.Venda;
import comum.util.HeaderUtil;
import comum.util.Util;
import comum.util.cluster.Opcoes;
import comum.util.cluster.exception.UtilException;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;
import comum.util.communication.Status;

public class ModelService extends ModelManager {
	
	private static Long messageIdentifier = 0L;
	
	protected Pacote modelPostOneUsuario(Usuario usuario) throws Exception {
		Pacote pacote = createPacote(Operation.POST_ONE, Entidade.USUARIO, Classe.MODELO, usuario);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		Lock lock = lockService.getLock("Usuario");
		lock.lock();
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			verifyResponse(result);
			
			commit(clusterModel, pacote);
			
			lock.unlock();
			pacote.setHeader(HeaderUtil.createHeaderRecebido());
			return pacote;
		} catch (UtilException e) {
			List<Address> rolbackList = e.getRolbackList();
			if (!rolbackList.isEmpty()) {
				rolback(rolbackList, pacote);
			}
			lock.unlock();
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelPostOneAnuncio(Anuncio anuncio) throws Exception {
		Pacote pacote = createPacote(Operation.POST_ONE, Entidade.ANUNCIO, Classe.MODELO, anuncio);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		Lock lockAnuncio = lockService.getLock("Anuncio");
		Lock lockProduto = lockService.getLock("Produto");
		lockAnuncio.lock();
		lockProduto.lock();
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			verifyResponse(result);
			
			commit(clusterModel, pacote);
			
			lockAnuncio.unlock();
			lockProduto.unlock();
			pacote.setHeader(HeaderUtil.createHeaderRecebido());
			return pacote;
		} catch (UtilException e) {
			List<Address> rolbackList = e.getRolbackList();
			if (!rolbackList.isEmpty()) {
				rolback(rolbackList, pacote);
			}
			lockAnuncio.unlock();
			lockProduto.unlock();
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelPostOneComentario(Comentario anuncio) throws Exception {
		Pacote pacote = createPacote(Operation.POST_ONE, Entidade.COMENTARIO, Classe.MODELO, anuncio);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		Lock lock = lockService.getLock("Comentario");
		lock.lock();
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			verifyResponse(result);
			
			commit(clusterModel, pacote);
			
			lock.unlock();
			pacote.setHeader(HeaderUtil.createHeaderRecebido());
			return pacote;
		} catch (UtilException e) {
			List<Address> rolbackList = e.getRolbackList();
			if (!rolbackList.isEmpty()) {
				rolback(rolbackList, pacote);
			}
			lock.unlock();
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelPostOneVenda(Venda venda) throws Exception {
		Pacote pacote = createPacote(Operation.POST_ONE, Entidade.VENDA, Classe.MODELO, venda);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		Lock lockVenda = lockService.getLock("Venda");
		Lock lockAnuncio = lockService.getLock("Anuncio");
		Lock lockUsuario = lockService.getLock("Usuario");
		lockVenda.lock();
		lockAnuncio.lock();
		lockUsuario.lock();
		
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			verifyResponse(result);
			
			commit(clusterModel, pacote);
			
			lockVenda.unlock();
			lockAnuncio.unlock();
			lockUsuario.unlock();
			pacote.setHeader(HeaderUtil.createHeaderRecebido());
			return pacote;
		} catch (UtilException e) {
			List<Address> rolbackList = e.getRolbackList();
			if (!rolbackList.isEmpty()) {
				rolback(rolbackList, pacote);
			}
			lockVenda.unlock();
			lockAnuncio.unlock();
			lockUsuario.unlock();
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelGetAllProduto() throws Exception {
		Pacote pacote = createPacote(Operation.GET_ALL, Entidade.PRODUTO, Classe.MODELO, null);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_FIRST, true, modelChannel.getAddress());
				
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			simpleVerifyResponse(result);
			
			return (Pacote) result.getFirst();
		} catch (UtilException e) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelGetByFilterUsuario(Usuario usuario) throws Exception {
		Pacote pacote = createPacote(Operation.GET_BY_FILTER, Entidade.USUARIO, Classe.MODELO, usuario);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_FIRST, true, modelChannel.getAddress());
				
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			simpleVerifyResponse(result);
			
			return (Pacote) result.getFirst();
		} catch (UtilException e) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelGetByFilterAnuncio(Anuncio anuncio) throws Exception {
		Pacote pacote = createPacote(Operation.GET_BY_FILTER, Entidade.ANUNCIO, Classe.MODELO, anuncio);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_FIRST, true, modelChannel.getAddress());
				
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			simpleVerifyResponse(result);
			
			return (Pacote) result.getFirst();
		} catch (UtilException e) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelGetOneAnuncio(Long id) throws Exception {
		Pacote pacote = createPacote(Operation.GET_ONE, Entidade.ANUNCIO, Classe.MODELO, id);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_FIRST, true, modelChannel.getAddress());
				
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			simpleVerifyResponse(result);
			
			return (Pacote) result.getFirst();
		} catch (UtilException e) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected Pacote modelGetByFilterComentario(Comentario comentario) throws Exception {
		Pacote pacote = createPacote(Operation.GET_BY_FILTER, Entidade.COMENTARIO, Classe.MODELO, comentario);
		Message mensagem = createMessage(null, pacote);
		Opcoes op = createOpcoes(ResponseMode.GET_FIRST, true, modelChannel.getAddress());
				
		try {
			Util.print("ENVIANDO: " + mensagem.toString());
			RspList<?> result = modelDispatcher.castMessage(clusterModel, mensagem, op.getOptions());
			Util.print("RESULTADO: " + result);
			
			simpleVerifyResponse(result);
			
			return (Pacote) result.getFirst();
		} catch (UtilException e) {
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected Opcoes createOpcoes(ResponseMode mode, boolean anycast, Address addrExclusion) {
		return new Opcoes(mode, anycast, addrExclusion);
	}
	
	protected Message createMessage(Address addr, Pacote pacote) {
		return new Message(addr, pacote);
	}
	
	protected Pacote createPacote(Operation op, Entidade ed, Classe cl, Object obj) {
		Pacote pacote = new Pacote(op, ed, cl, obj);
		pacote.setHeader(HeaderUtil.createHeaderEnvio(null, geraToken(messageIdentifier), pacote));
		messageIdentifier += 1;
		return pacote;
	}
	
	protected String geraToken(Long identifier) {
		return modelChannel.getAddressAsString() + "_" + identifier.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void rolback(List<Address> rolbackList, Pacote pacote) throws Exception {
		pacote.setOperacao(Operation.ROLBACK);
		pacote.setClasse(Classe.MODELO);
		pacote.setContent(null);
		pacote.setEntidade(null);
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		
		try {
			modelDispatcher.castMessage(rolbackList, mensagem, op.getOptions());
		} catch (UtilException e) {
			throw new UtilException("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	protected void commit(List<Address> commitList, Pacote pacote) throws Exception {
		pacote.setOperacao(Operation.COMMIT);
		pacote.setClasse(Classe.MODELO);
		pacote.setContent(null);
		pacote.setEntidade(null);
		
		Message mensagem = new Message(null, pacote);
		Opcoes op = new Opcoes(ResponseMode.GET_ALL, true, modelChannel.getAddress());
		
		try {
			modelDispatcher.castMessage(commitList, mensagem, op.getOptions());
		} catch (UtilException e) {
			throw new UtilException("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		}
	}
	
	
	

	protected void simpleVerifyResponse(RspList<?> retorno) throws Exception {
		if (retorno.isEmpty())
			throw new UtilException();
		Pacote pacote = (Pacote) retorno.getFirst();
		if (pacote.getHeader().getStatus().equals(Status.ERROR))
			throw new UtilException();
	}
	
	protected void verifyResponse(RspList<?> retorno) throws Exception {
		List<Address> rolbackList = getResponseRolbackList(retorno);
		if (retorno.isEmpty())
			throw new UtilException(rolbackList);
		if (retorno.size() < clusterModel.size())
			throw new UtilException(rolbackList);
		if (!rolbackList.isEmpty()) {
			throw new UtilException(rolbackList);
		}
	}
	
	protected List<Address> getResponseRolbackList(RspList<?> retorno) {
		List<Address> rolbackList = new ArrayList<Address>();
		boolean isRoolback = false;
		Set<Address> set = retorno.keySet();
		for (Address receiver: set) {
			Rsp<?> response = retorno.get(receiver);
			Pacote result = (Pacote) response.getValue();
			if (result.getHeader().getStatus().equals(Status.ERROR)) {
				isRoolback = true;
			} else {
				rolbackList.add(receiver);
			}
		}
		
		if (isRoolback) {
			return rolbackList;
		}
		return new ArrayList<Address>();
	}

}
