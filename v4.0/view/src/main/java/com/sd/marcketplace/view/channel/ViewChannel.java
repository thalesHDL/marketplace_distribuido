package com.sd.marcketplace.view.channel;

import java.util.ArrayList;

import org.jgroups.Address;

import com.sd.marcketplace.view.channel.service.ViewService;
import com.sd.marcketplace.view.comum.enumerate.Status;
import com.sd.marcketplace.view.comum.objeto.SharedObject;
import com.sd.marcketplace.view.entidades.Usuario;
import com.sd.marcketplace.view.form.Login;

public class ViewChannel extends ViewService {
	
	public ViewChannel() {
		// Empty constructor
	}
	
	public void startChannel(SharedObject share) throws Exception {
		this.user = null;
		this.share = share;
		this.clusterController = new ArrayList<Address>();
		this.initChannel(VIEW_CHANNEL);
	}
	
	@Override
	public void eventLoop() throws Exception {
		System.out.println("START LOOP");
		mvc();
		
		while(true) {
			if(this.share.getStatus().equals(Status.READY)) {
				logar();
			}
			sleep(5000);
		}
	}
	
		
	public void mvc() throws Exception {
		this.clusterController = getAllController();
		
		if (this.clusterController.size() < N_CONTROLLER) {
			registerController();
		}
	}
	
	public void logar() throws Exception {
		if(this.user == null || this.user.getId() == null) {
			System.out.flush();
			Login l = new Login();
			Usuario newUser = l.doLogin();
			this.user = postUsuario(newUser);
		}
	}

}
