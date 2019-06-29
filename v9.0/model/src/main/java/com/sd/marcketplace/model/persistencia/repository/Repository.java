package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Repository {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	public UsuarioRepository usuario() {
		return usuarioRepository;
	}
	public ProdutoRepository produto() {
		return produtoRepository;
	}

}
