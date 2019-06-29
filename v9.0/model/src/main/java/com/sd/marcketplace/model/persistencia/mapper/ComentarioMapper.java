package com.sd.marcketplace.model.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.marcketplace.model.persistencia.table.TableComentario;

import comum.domain.Comentario;

@Component
public class ComentarioMapper {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private AnuncioMapper anuncioMapper;

    public TableComentario toTable(Comentario entity) {
        TableComentario table = new TableComentario();
        
        table.setId(entity.getId());
        table.setMensagem(entity.getMensagem());
        table.setData(entity.getData());
        table.setUsuario(usuarioMapper.toTable(entity.getUsuario()));
        table.setAnuncio(anuncioMapper.toTable(entity.getAnuncio()));
        
        return table;
    }

    public Comentario toEntity(TableComentario table) {
        Comentario entity = new Comentario();
        
        entity.setId(table.getId());
        entity.setMensagem(table.getMensagem());
        entity.setData(table.getData());
        entity.setUsuario(usuarioMapper.toEntity(table.getUsuario()));
        entity.setAnuncio(anuncioMapper.toEntity(table.getAnuncio()));
        
        return entity;
    }

    public List<TableComentario> toTable(List<Comentario> list) {
        List<TableComentario> result = new ArrayList<TableComentario>();
        for (Comentario entity: list) {
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