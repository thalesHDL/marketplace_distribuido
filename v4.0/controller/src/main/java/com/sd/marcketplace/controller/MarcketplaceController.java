package com.sd.marcketplace.controller;

import com.sd.marcketplace.controller.channel.ControllerChannel;
import com.sd.marcketplace.controller.comum.objeto.SharedObject;

public class MarcketplaceController {
	
    public static void main( String[] args ) throws Exception {
    	new ControllerChannel().startChannel(new SharedObject());
    }
    
}
