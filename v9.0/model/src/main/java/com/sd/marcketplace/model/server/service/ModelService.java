package com.sd.marcketplace.model.server.service;

import javax.persistence.EntityTransaction;

import org.jgroups.Address;
import com.sd.marcketplace.model.persistencia.table.TableUsuario;
import com.sd.marcketplace.model.server.manager.ModelManager;

import comum.domain.Usuario;
import comum.util.PacoteUtil;

public class ModelService extends ModelManager {

	protected Usuario postUsuario(Usuario usuario) {
		// TODO: cadastrar usuario
		return null;
	}
	
	protected Address modelGetOneAddress() {
		return modelChannel.getAddress();
	}
	
	protected Object modelPostOneUsuario(Usuario entity, String identifier) throws Exception {
		TableUsuario table = usuarioMapper.toTable(entity);
		EntityTransaction operacao;
		try {
			table = usuarioRepository.save(table);
//			operacao = usuarioRepository.getTransaction();
			entity = usuarioMapper.toEntity(table);
//			addOperation(identifier, operacao);
			return PacoteUtil.createPacoteRecebido(entity, identifier);
		} catch (Exception e) {
//			operacao = usuarioRepository.getTransaction();
//			addOperation(identifier, operacao);
			throw new Exception();
		}		
	}
	
}
