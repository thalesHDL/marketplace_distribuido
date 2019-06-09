package com.sd.marcketplace.visao.runner;

import com.sd.marcketplace.visao.recursos.VisaoChannel;

public class VisaoRunner implements Runnable {
	
	@Override
	public void run() {
		try {
			new VisaoChannel().initChannel();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
