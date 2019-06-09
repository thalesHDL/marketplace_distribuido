package com.sd.marcketplace.view;

import com.sd.marcketplace.view.channel.Chat;
import com.sd.marcketplace.view.channel.ViewChannel;
import com.sd.marcketplace.view.runner.ViewRunner;

public class App {
    
	public static void main( String[] args ) throws Exception {
//		new ViewRunner().start();
//		new Chat().start();
		new ViewChannel().startChannel();
    }
	
}
