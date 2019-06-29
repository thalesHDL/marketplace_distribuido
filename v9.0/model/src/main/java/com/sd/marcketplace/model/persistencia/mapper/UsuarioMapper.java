package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<TableUsuario> toTable(List<Usuario> list) {
		List<TableUsuario> result = new ArrayList<TableUsuario>();
		for (Usuario entity: list) {
			result.add(toTable(entity));
		}
		return result;
	}
	
	public List<Usuario> toEntity(List<TableUsuario> list) {
		List<Usuario> result = new ArrayList<Usuario>();
		for (TableUsuario table: list) {
			result.add(toEntity(table));
		}
		return result;
	}


}
