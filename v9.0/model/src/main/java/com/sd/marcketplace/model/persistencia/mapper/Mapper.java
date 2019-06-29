package com.sd.marcketplace.model.persistencia.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	@Autowired
	private ProdutoMapper produtoMapper;
	@Autowired
	private AnuncioMapper anuncioMapper;
	@Autowired
	private ComentarioMapper comentarioMapper;
	@Autowired
	private VendaMapper vendaMapper;
	
	
	
	public UsuarioMapper usuario() {
		return usuarioMapper;
	}
	public ProdutoMapper produto() {
		return produtoMapper;
	}
	
	public AnuncioMapper anuncio() {
		return anuncioMapper;
	}
	
	public ComentarioMapper comentario() {
		return comentarioMapper;
	}
	
	public VendaMapper venda() {
		return vendaMapper;
	}

}
