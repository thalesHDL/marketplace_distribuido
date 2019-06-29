package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sd.marcketplace.model.persistencia.table.TableComentario;

import comum.domain.Comentario;

public class ComentarioMapper {

	public TableComentario toTable(Comentario entity) {
		TableComentario table = new TableComentario();
		table.setId(entity.getId());
		table.setNome(entity.getNome());
		return table;
	}
	
	public Comentario toEntity(TableComentario table) {
		Comentario entity = new Comentario();
		entity.setId(table.getId());
		entity.setNome(table.getNome());
		return entity;
	}
	
	public List<TableComentario> toTable(List<Produto> list) {
		List<TableComentario> result = new ArrayList<TableComentario>();
		for (Produto entity: list) {
			result.add(toTable(entity));
		}
		return result;
	}
	
	public List<Comentario> toEntity(List<TableComentario> list) {
		List<Comentario> result = new ArrayList<Comentario>();
		for (TableComentario table: list) {
			result.add(toEntity(table));
		}
		return result;
	}

}
