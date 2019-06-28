package com.sd.marcketplace.model.persistencia.mapper;

import org.springframework.stereotype.Component;

import com.sd.marcketplace.model.persistencia.table.TableUsuario;

import comum.domain.Usuario;

@Component
public class UsuarioMapper {
	
	public TableUsuario toTable(Usuario entity) {
		TableUsuario table = new TableUsuario();
		
		table.setId(entity.getId());
		table.setEmail(entity.getEmail());
		table.setNome(entity.getNome());
		table.setSenha(entity.getSenha());
		
		return table;
	}
	
	public Usuario toEntity(TableUsuario table) {
		Usuario entity = new Usuario();
		
		entity.setId(table.getId());
		entity.setEmail(table.getEmail());
		entity.setNome(table.getNome());
		entity.setSenha(table.getSenha());
		
		return entity;
	}

}
