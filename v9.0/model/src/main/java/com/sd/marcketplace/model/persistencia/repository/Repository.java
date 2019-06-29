package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Repository {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private AnuncioRepository anuncioRepository;
	@Autowired
	private ComentariosRepository comentarioRepository;
	
	
	
	public UsuarioRepository usuario() {
		return usuarioRepository;
	}
	public ProdutoRepository produto() {
		return produtoRepository;
	}
	public AnuncioRepository anuncio() {
		return anuncioRepository;
	}
	public ComentariosRepository comentario() {
		return comentarioRepository;
	}

}
