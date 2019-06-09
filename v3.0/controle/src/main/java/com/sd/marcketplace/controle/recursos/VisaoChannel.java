package com.sd.marcketplace.controle.recursos;

import org.jgroups.JChannel;
import org.jgroups.util.RspList;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.objeto.SendObject;
import com.sd.marcketplace.controle.comum.objeto.SharedObject;
import com.sd.marcketplace.controle.recursos.servico.VisaoServico;


public class VisaoChannel extends VisaoServico {
	
	private static final String CANAL_VISAO = "VisaoChannel";
	
		
	public VisaoChannel() {
		// Empty constructor
	}
	
	public void initChannel(SharedObject sharedObj) throws Exception {	
		this.sharedObj = sharedObj;
		
		this.channel = new JChannel();
		
		this.initHandler(this.channel);
		
		this.channel.connect(CANAL_VISAO);
		this.updateChannelCoordenador();
		this.eventLoop();
		this.channel.close();
	}
	
	private void updateChannelCoordenador() throws Exception {
		this.dest = this.channel.getAddress();
		
		SendObject obj = new SendObject();
		obj.setAcao(Action.GET_ONE);
		obj.setEntidade(Entidade.COORDENADOR);
		obj.setContent(this.dest);
		
		RspList result = this.enviaMultcast(obj);
		System.out.println("results: ".concat(result.getResults().toString()));
	}
	
	private void eventLoop() throws Exception {
		while(true) {
			sleep(100);
		}
	}
}
