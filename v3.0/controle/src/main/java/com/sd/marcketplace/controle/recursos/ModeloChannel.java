package com.sd.marcketplace.controle.recursos;

import java.util.List;

import org.jgroups.JChannel;

import com.sd.marcketplace.controle.comum.enumerate.Action;
import com.sd.marcketplace.controle.comum.enumerate.Entidade;
import com.sd.marcketplace.controle.comum.enumerate.Status;
import com.sd.marcketplace.controle.comum.objeto.SendObject;
import com.sd.marcketplace.controle.comum.objeto.SharedObject;
import com.sd.marcketplace.controle.entidades.Usuario;
import com.sd.marcketplace.controle.recursos.servico.ModeloServico;


public class ModeloChannel extends ModeloServico {
	
	private static final String CANAL_MODELO = "ModeloChannel";
	
	private JChannel channel;
	
	public ModeloChannel() {
		// Empty constructor
	}
	
	public void initChannel(SharedObject sharedObj) throws Exception {	
		this.sharedObj = sharedObj;
		
		this.channel = new JChannel();
		
		initHandler(this.channel);
		
		this.channel.connect(CANAL_MODELO);
		this.eventLoop();
		this.channel.close();
	}
	
	private void eventLoop() throws Exception {
		while (true) {
			if (this.sharedObj.getStatus().equals(Status.NOTIFY_MODELO)) {
				trataAcao(this.sharedObj.getObj());
			}
			sleep(10);
		}
	}
	
	private void trataAcao(SendObject sendObj) throws Exception {
		if(sendObj.getAcao().equals(Action.GET_BY_FILTER)) {
			trataEntidade(sendObj);
		}
	}
	
	private void trataEntidade(SendObject sendObj) throws Exception {
		if(sendObj.getEntidade().equals(Entidade.USUARIO)) {
			List<Usuario> listUsuario = this.getUsuarioByFilter(sendObj);
			this.sharedObj.setContentObject(listUsuario);
			this.sharedObj.setStatus(Status.NOTIFY_CONTROLE);
		}
	}
	

}
