package com.sd.marcketplace.view.runner;

import com.sd.marcketplace.view.channel.ViewChannel;

public class ViewRunner extends Thread {
	
	public void run() {
		try {
			new ViewChannel().startChannel();
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
