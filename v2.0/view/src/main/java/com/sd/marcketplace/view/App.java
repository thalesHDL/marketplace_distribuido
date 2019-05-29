package com.sd.marcketplace.view;

import com.sd.marcketplace.view.network.ModelChannel;
import com.sd.marcketplace.view.network.ViewChannel;
import com.sd.marcketplace.view.network.message.SharedMessage;

public class App {
    
	public static void main( String[] args ) {
		SharedMessage message = new SharedMessage();
        new Thread(new ModelChannel(message)).start();
        new Thread(new ViewChannel(message)).start();
    }
	
}
