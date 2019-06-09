package com.sd.marcketplace.modelo.recursos;

import org.jgroups.JChannel;

import com.sd.marcketplace.modelo.entidades.Usuario;
import com.sd.marcketplace.modelo.recursos.handler.ModeloHandler;

public class ModeloChannel extends ModeloHandler {
	
	private static final String CANAL_MODELO = "ModeloChannel";
	
	private JChannel channel;
	
	public ModeloChannel() {
		// Empty constructor
	}
	
	public void initChannel() throws Exception {		
		this.channel = new JChannel();
		
		this.initHandler(this.channel);
				
		this.channel.connect(CANAL_MODELO);
		this.eventLoop();
		this.channel.close();
	}
	
	private void eventLoop() throws Exception {
		// TODO: carregar este db com os valores dos outros dbs do canal
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@teste.teste");
		usuario.setSenha("teste");
		usuario.setId(1L);
		this.db.dbUsuario.add(usuario);
	}

}
