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
	private ComentarioRepository comentarioRepository;
	@Autowired
	private VendaRepository vendaRepository;
	
	
	
	public UsuarioRepository usuario() {
		return usuarioRepository;
	}
	public ProdutoRepository produto() {
		return produtoRepository;
	}
	public AnuncioRepository anuncio() {
		return anuncioRepository;
	}
	public ComentarioRepository comentario() {
		return comentarioRepository;
	}
	public VendaRepository venda() {
		return vendaRepository;
	}

}
