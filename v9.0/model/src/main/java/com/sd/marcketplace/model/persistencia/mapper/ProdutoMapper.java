package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.marcketplace.model.persistencia.table.TableProduto;

import comum.domain.Produto;

@Component
public class ProdutoMapper {
	
	public TableProduto toTable(Produto entity) {
		TableProduto table = new TableProduto();
		table.setId(entity.getId());
		table.setNome(entity.getNome());
		return table;
	}
	
	public Produto toEntity(TableProduto table) {
		Produto entity = new Produto();
		entity.setId(table.getId());
		entity.setNome(table.getNome());
		return entity;
	}
	
	public List<TableProduto> toTable(List<Produto> list) {
		List<TableProduto> result = new ArrayList<TableProduto>();
		for (Produto entity: list) {
			result.add(toTable(entity));
		}
		return result;
	}
	
	public List<Produto> toEntity(List<TableProduto> list) {
		List<Produto> result = new ArrayList<Produto>();
		for (TableProduto table: list) {
			result.add(toEntity(table));
		}
		return result;
	}

}
