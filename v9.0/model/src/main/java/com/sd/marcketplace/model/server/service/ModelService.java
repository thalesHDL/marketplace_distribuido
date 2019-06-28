package com.sd.marcketplace.model.server.service;

import java.util.List;

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
		// TODO: dar um jeito de criar fazer oi rollback
//		EntityTransaction operacao;
		try {
			table = repository.usuario().save(table);
//			operacao = usuarioRepository.getTransaction();
			entity = usuarioMapper.toEntity(table);
			List<TableUsuario> l = repository.usuario().getAll();
			System.out.println(l.toString());
//			addOperation(identifier, operacao);
			return PacoteUtil.createPacoteRecebido(entity, identifier);
		} catch (Exception e) {
//			operacao = usuarioRepository.getTransaction();
//			addOperation(identifier, operacao);
			throw new Exception();
		}		
	}
	
}
