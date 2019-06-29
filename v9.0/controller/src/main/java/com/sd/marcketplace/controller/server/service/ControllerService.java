package com.sd.marcketplace.controller.server.service;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.controller.server.manager.ControllerManager;

import comum.domain.Anuncio;
import comum.domain.Comentario;
import comum.domain.Usuario;
import comum.domain.Venda;
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
	
	protected Pacote controllerPostOneAnunncio(Anuncio anuncio) throws Exception {
		return modelPostOneAnuncio(anuncio);
	}
	
	protected Pacote controllerPostOneComentario(Comentario comentario) throws Exception {
		return modelPostOneComentario(comentario);
	}
	
	protected Pacote controllerPostOneVenda(Venda venda) throws Exception {
		return modelPostOneVenda(venda);
	}
	
	protected Pacote controllerGetAllProduto() throws Exception {
		return modelGetAllProduto();
	}
	
	protected Pacote controllerGetByFilterUsuario(Usuario usuario) throws Exception {
		return modelGetByFilterUsuario(usuario);
	}
	
	protected Pacote controllerGetByFilterAnuncio(Anuncio anuncio) throws Exception {
		return modelGetByFilterAnuncio(anuncio);
	}
	
	protected Pacote controllerGetOneAnuncio(Long id) throws Exception {
		return modelGetOneAnuncio(id);
	}
	
	protected Pacote controllerGetByFilterComentario(Comentario comentario) throws Exception {
		return modelGetByFilterComentario(comentario);
	}
}
