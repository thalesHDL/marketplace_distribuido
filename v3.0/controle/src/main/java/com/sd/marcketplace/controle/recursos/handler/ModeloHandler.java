package com.sd.marcketplace.controle.recursos.handler;

import org.jgroups.Message;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.enumerate.Status;
import com.sd.marcketplace.controle.comum.objeto.SendObject;

public class ModeloHandler extends BasicoHandler {
	
	@Override
	public Object handle(Message msg) throws Exception {
		System.out.println("[CONTROLE (ModeloChannel)] received message: ".concat(msg.toString()));
		return trataMensagem(msg);
	}
	
	public Object trataMensagem(Message msg) {
		SendObject receive = (SendObject) msg.getObject();
		if(receive.getAcao().equals(Action.GET_BY_FILTER)) {
			trataGetByFilter(receive);
		}
		return receive;
	}
	
	public Object trataGetByFilter(SendObject sendObj) {
		if(sendObj.getEntidade().equals(Entidade.USUARIO)) {
			this.sharedObj.setObj(sendObj);
			this.sharedObj.setStatus(Status.NOTIFY_MODELO);
		}
		return sendObj;
	}
	
	
	
}
