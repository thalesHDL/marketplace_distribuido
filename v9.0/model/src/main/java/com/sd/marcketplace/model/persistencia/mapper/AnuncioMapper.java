package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;

import comum.domain.Anuncio;


public class AnuncioMapper {
	public TableAnuncio toTable(Anuncio entity) {
		TableAnuncio table = new TableAnuncio();
		
		table.setId(entity.getId());
		table.setDescricao(entity.getDescricao());
		table.setPreco(entity.getPreco());
		table.setQuantidade(entity.getQuantidade());
		
		return table;
	}
	
	public Anuncio toEntity(TableAnuncio table) {
		Anuncio entity = new Anuncio();
		
		entity.setId(table.getId());
		entity.setDescricao(table.getDescricao());
		entity.setPreco(table.getPreco());
		entity.setQuantidade(table.getQuantidade());
		
		return entity;
	}
	
	public List<TableAnuncio> toTable(List<Anuncio> list) {
		List<TableAnuncio> result = new ArrayList<TableAnuncio>();
		for (Anuncio entity: list) {
			result.add(toTable(entity));
		}
		return result;
	}
	
	public List<Anuncio> toEntity(List<TableAnuncio> list) {
		List<Anuncio> result = new ArrayList<Anuncio>();
		for (TableAnuncio table: list) {
			result.add(toEntity(table));
		}
		return result;
	}

}
