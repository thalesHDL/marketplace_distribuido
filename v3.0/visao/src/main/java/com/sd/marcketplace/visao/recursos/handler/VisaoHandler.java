package com.sd.marcketplace.visao.recursos.handler;

import org.jgroups.Address;
import org.jgroups.Message;

import com.sd.marcketplace.visao.comum.enumerate.Action;
import com.sd.marcketplace.visao.comum.enumerate.Entidade;
import com.sd.marcketplace.visao.comum.objeto.SendObject;


public class VisaoHandler extends BasicoHandler {
	
	
	
	@Override
	public Object handle(Message msg) throws Exception {
		System.out.println("[VISAO (VisaoChannel)] received message: ".concat(msg.toString()));
		if(msg.getSrc().equals(this.channel.getAddress())) {
			System.out.println("[VISAO (VisaoChannel)] a mensagem foi enviada por mim mesmo: ".concat(msg.toString()));
			return new Message();
		}
		System.out.println("[VISAO (VisaoChannel)] a mensagem nao foi enviada por mim mesmo: ".concat(msg.toString()));
		return trataMensagem(msg);
	}
	
	private Object trataMensagem(Message msg) throws Exception {
		SendObject receive = (SendObject) msg.getObject();
		return trataAcao(receive);
	}
	
	private Object trataAcao(SendObject sendObj) throws Exception {
		if(sendObj.getAcao().equals(Action.GET_ONE)) {
			return trataEntidade(sendObj);
		}
		return sendObj;
	}
	
	private Object trataEntidade(SendObject sendObj) throws Exception {
		if(sendObj.getEntidade().equals(Entidade.COORDENADOR)) {
//			this.coord = (Address) sendObj.getContent();
			return null;
		}
		return sendObj;
	}
	
}
