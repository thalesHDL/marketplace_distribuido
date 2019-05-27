package com.sd.marcketplace.view;

import com.sd.marcketplace.view.network.ViewChannel;

public class App {
    
	public static void main( String[] args ) {
        new Thread(new ViewChannel()).start();
    }
	
}
