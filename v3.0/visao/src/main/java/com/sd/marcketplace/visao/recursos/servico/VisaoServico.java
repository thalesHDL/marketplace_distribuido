package com.sd.marcketplace.visao.recursos.servico;

import org.jgroups.util.RspList;

import com.sd.marcketplace.visao.comum.enumerate.Action;
import com.sd.marcketplace.visao.comum.enumerate.Entidade;
import com.sd.marcketplace.visao.comum.objeto.SendObject;
import com.sd.marcketplace.visao.entidades.Usuario;
import com.sd.marcketplace.visao.recursos.handler.VisaoHandler;

public class VisaoServico extends VisaoHandler {
	
	public Usuario getUsuarioByFilter(Usuario usuario) throws Exception {
		System.out.println("getUsuarioByFilter");
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
