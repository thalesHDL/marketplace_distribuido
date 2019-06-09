package com.sd.marcketplace.entrega;

import com.sd.marcketplace.entrega.channel.Channel;

public class App {
	
    public static void main( String[] args ) {
        try {

			new Channel().startChannel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
