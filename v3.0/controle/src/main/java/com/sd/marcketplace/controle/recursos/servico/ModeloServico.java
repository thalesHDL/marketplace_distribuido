package com.sd.marcketplace.controle.recursos.servico;

import java.util.List;

import org.jgroups.util.RspList;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.objeto.SendObject;
import com.sd.marcketplace.controle.entidades.Usuario;
import com.sd.marcketplace.controle.recursos.handler.ModeloHandler;

public class ModeloServico extends ModeloHandler {
	
	public List<Usuario> getUsuarioByFilter(SendObject sendObj) throws Exception {		
		RspList result = enviaAnycast(sendObj);
		System.out.println(result);
		System.out.println(result.getResults().get(0));
		return (List<Usuario>) result.getResults().get(0);
	}

}
