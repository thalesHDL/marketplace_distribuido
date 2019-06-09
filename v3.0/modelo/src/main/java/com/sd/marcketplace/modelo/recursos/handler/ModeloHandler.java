package com.sd.marcketplace.modelo.recursos.handler;

import org.jgroups.Message;

import com.sd.marcketplace.modelo.comum.enumerate.Action;
import com.sd.marcketplace.modelo.comum.enumerate.Entidade;
import com.sd.marcketplace.modelo.comum.objeto.SendObject;
import com.sd.marcketplace.modelo.recursos.servico.ModeloServico;

public class ModeloHandler extends ModeloServico {
	
	@Override
	public Object handle(Message msg) throws Exception {
		System.out.println("[MODELO] received message: ".concat(msg.toString()));
		trataMensagem(msg);
		return msg;
	}
	
	private Object trataMensagem(Message msg) throws Exception {
		SendObject receive = (SendObject) msg.getObject();
		return trataAcao(receive);
	}
	
	private Object trataAcao(SendObject sendObj) throws Exception {
		if(sendObj.getAcao().equals(Action.GET_BY_FILTER)) {
			return trataEntidade(sendObj);
		}
		return sendObj;
	}
	
	private Object trataEntidade(SendObject sendObj) throws Exception {
		if(sendObj.getEntidade().equals(Entidade.USUARIO)) {
			return getUsuarioByFilter(sendObj);
		}
		return sendObj;
	}
	
}
