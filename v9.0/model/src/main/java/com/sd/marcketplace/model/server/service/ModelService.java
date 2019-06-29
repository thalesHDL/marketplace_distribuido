package com.sd.marcketplace.model.server.service;

import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;
import com.sd.marcketplace.model.persistencia.table.TableProduto;
import com.sd.marcketplace.model.persistencia.table.TableUsuario;
import com.sd.marcketplace.model.server.manager.ModelManager;

import comum.domain.Anuncio;
import comum.domain.Produto;
import comum.domain.Usuario;
import comum.util.PacoteUtil;

public class ModelService extends ModelManager {
	
	protected Address modelGetOneAddress() {
		return modelChannel.getAddress();
	}
	
	protected Object modelPostOneUsuario(Usuario entity, String identifier) throws Exception {
		TableUsuario table = mapper.usuario().toTable(entity);
		// TODO: dar um jeito de criar fazer oi rollback
//		EntityTransaction operacao;
		try {
			table = repository.usuario().save(table);
//			operacao = usuarioRepository.getTransaction();
			entity = mapper.usuario().toEntity(table);
//			addOperation(identifier, operacao);
			return PacoteUtil.createPacoteRecebido(entity, identifier);
		} catch (Exception e) {
//			operacao = usuarioRepository.getTransaction();
//			addOperation(identifier, operacao);
			throw new Exception();
		}		
	}
	
	protected Object modelGetAllProduto(String identifier) throws Exception {
		try {
			List<TableProduto> result = repository.produto().findAll();
			List<Produto> retorno = mapper.produto().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
	protected Object modelGetByFilterAnuncio(Anuncio anuncio, String identifier) throws Exception {
		try {
//			List<TableAnuncio> result = repository.anuncio().findByFilter(filter);// TODO fazer o filtro
			List<TableAnuncio> result = null;
			List<Anuncio> retorno = mapper.anuncio().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
	protected Object modelGetOneAnuncio(Long id, String identifier) throws Exception {
		try {
			TableAnuncio result = repository.anuncio().getOne(id);
			Anuncio retorno = mapper.anuncio().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
}
