package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;

import comum.domain.Anuncio;

@Component
public class AnuncioMapper {
	
	@Autowired
	private ProdutoMapper produtoMapper;
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public TableAnuncio toTable(Anuncio entity) {
		TableAnuncio table = new TableAnuncio();
		
		table.setId(entity.getId());
		table.setDescricao(entity.getDescricao());
		table.setPreco(entity.getPreco());
		table.setQuantidade(entity.getQuantidade());
		table.setProduto(produtoMapper.toTable(entity.getProduto()));
		table.setVendedor(usuarioMapper.toTable(entity.getVendedor()));
		
		return table;
	}
	
	public Anuncio toEntity(TableAnuncio table) {
		Anuncio entity = new Anuncio();
		
		entity.setId(table.getId());
		entity.setDescricao(table.getDescricao());
		entity.setPreco(table.getPreco());
		entity.setQuantidade(table.getQuantidade());
		entity.setProduto(produtoMapper.toEntity(table.getProduto()));
		entity.setVendedor(usuarioMapper.toEntity(table.getVendedor()));
		
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
