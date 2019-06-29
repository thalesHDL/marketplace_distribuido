package com.sd.marcketplace.view.server.service;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.blocks.ResponseMode;

import com.sd.marcketplace.view.server.manager.ControllerManager;

import comum.domain.Anuncio;
import comum.domain.Produto;
import comum.domain.Usuario;
import comum.util.HeaderUtil;
import comum.util.Util;
import comum.util.cluster.Opcoes;
import comum.util.communication.Classe;
import comum.util.communication.Entidade;
import comum.util.communication.Operation;
import comum.util.communication.Pacote;
import comum.util.communication.Status;

@SuppressWarnings("unchecked")
public class ControllerService extends ControllerManager {
	
	protected Usuario controllerPostUsuario(Usuario usuario) {
		try {
			Pacote pacote = new Pacote(Operation.POST_ONE, Entidade.USUARIO, Classe.CONTROLE, usuario);
			pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
			
			Address dest = sorteiaMemberClusterController();
			
			Message mensagem = new Message(dest, pacote);
			Opcoes op = new Opcoes(ResponseMode.GET_FIRST, false, controllerChannel.getAddress());
						
			Util.print("ENVIANDO: " + mensagem.toString());
			Pacote result = controllerDispatcher.sendMessage(mensagem, op.getOptions());
			Util.print("RESULTADO: " + result.toString());
			
			usuario = (Usuario) getResoultado(pacote);
			
			return usuario;
		} catch (Exception e) {
			Util.print(e.getMessage());
			return usuario;
		}
	}
	
	
	protected List<Produto> getAllProdutos() {
		try {
			Pacote pacote = new Pacote(Operation.GET_ALL, Entidade.PRODUTO, Classe.CONTROLE, null);
			pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
			
			Address dest = sorteiaMemberClusterController();
			
			Message mensagem = new Message(dest, pacote);
			Opcoes op = new Opcoes(ResponseMode.GET_FIRST, false, controllerChannel.getAddress());
						
			Pacote result = controllerDispatcher.sendMessage(mensagem, op.getOptions());
			List<Produto> listProdutos = (List<Produto>) getResoultado(result);
			return listProdutos;
		} catch (Exception e) {
			Util.print(e.getMessage());
			return new ArrayList<Produto>();
		}
	}
	
	protected List<Anuncio> getByFilterAnuncios(Anuncio anuncio) {
		try {
			Pacote pacote = new Pacote(Operation.GET_BY_FILTER, Entidade.ANUNCIO, Classe.CONTROLE, anuncio);
			pacote.setHeader(HeaderUtil.createHeaderEnvio(null, null, pacote));
			
			Address dest = sorteiaMemberClusterController();
			
			Message mensagem = new Message(dest, pacote);
			Opcoes op = new Opcoes(ResponseMode.GET_FIRST, false, controllerChannel.getAddress());
						
			Pacote result = controllerDispatcher.sendMessage(mensagem, op.getOptions());
			List<Anuncio> listProdutos = (List<Anuncio>) getResoultado(result);
			return listProdutos;
		} catch (Exception e) {
			Util.print(e.getMessage());
			return new ArrayList<Anuncio>();
		}
	}
	
	
	
	
	
	
	protected Object getResoultado(Pacote pacote) throws Exception {
		if (pacote == null)
			throw new Exception("Não é possível realizar esta operação, por favor tente novamente mais tarde");
		if (pacote.getHeader().getStatus().equals(Status.ERROR))
			throw new Exception(pacote.getHeader().getMsg());
		
		return pacote.getContent();
	}
}
