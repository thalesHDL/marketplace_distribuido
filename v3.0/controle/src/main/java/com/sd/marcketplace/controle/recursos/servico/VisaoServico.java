package com.sd.marcketplace.controle.recursos.servico;

import org.jgroups.util.RspList;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.objeto.SendObject;
import com.sd.marcketplace.controle.entidades.Usuario;
import com.sd.marcketplace.controle.recursos.handler.VisaoHandler;

public class VisaoServico extends VisaoHandler {
	
	public Usuario getUsuarioByFilter(Usuario usuario) throws Exception {
		SendObject sendObj = new SendObject();
		sendObj.setAcao(Action.GET_BY_FILTER);
		sendObj.setEntidade(Entidade.USUARIO);
		sendObj.setContent(usuario);
		
		RspList result = enviaAnycast(sendObj);
		System.out.println(result);
		System.out.println(result.getResults().get(0));
		return (Usuario) result.getResults().get(0);
	}

}
