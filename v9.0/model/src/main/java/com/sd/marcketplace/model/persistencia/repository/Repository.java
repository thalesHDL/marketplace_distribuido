package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Repository {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioRepository usuario() {
		return usuarioRepository;
	}

}
