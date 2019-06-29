package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.marcketplace.model.persistencia.table.TableVenda;

import comum.domain.Venda;

@Component
public class VendaMapper {
	
	@Autowired
	private AnuncioMapper anuncioMapper;
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public TableVenda toTable(Venda entity) {
		TableVenda table = new TableVenda();
				
		table.setId(entity.getId());
		table.setData(entity.getData());
		table.setQuantidade(entity.getQuantidade());
		table.setAnuncio(anuncioMapper.toTable(entity.getAnuncio()));
		table.setConsumidor(usuarioMapper.toTable(entity.getConsumidor()));
		
		return table;
	}
	
	public Venda toEntity(TableVenda table) {
		Venda entity = new Venda();
		
		entity.setId(table.getId());
		entity.setData(table.getData());
		entity.setQuantidade(table.getQuantidade());
		entity.setAnuncio(anuncioMapper.toEntity(table.getAnuncio()));
		entity.setConsumidor(usuarioMapper.toEntity(table.getConsumidor()));
		
		return entity;
	}
	
	public List<TableVenda> toTable(List<Venda> list) {
		List<TableVenda> result = new ArrayList<TableVenda>();
		for (Venda entity: list) {
			result.add(toTable(entity));
		}
		return result;
	}
	
	public List<Venda> toEntity(List<TableVenda> list) {
		List<Venda> result = new ArrayList<Venda>();
		for (TableVenda table: list) {
			result.add(toEntity(table));
		}
		return result;
	}

}
