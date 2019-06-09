package com.sd.marcketplace.modelo.recursos.servico;

import java.util.List;

import com.sd.marcketplace.modelo.comum.objeto.SendObject;
import com.sd.marcketplace.modelo.entidades.Usuario;
import com.sd.marcketplace.modelo.recursos.handler.BasicoHandler;

public class ModeloServico extends BasicoHandler {
	
	public List<Usuario> getUsuarioByFilter(SendObject sendObj) throws Exception {
		return this.db.dbUsuario.getAll();		
	}
	
	

}
