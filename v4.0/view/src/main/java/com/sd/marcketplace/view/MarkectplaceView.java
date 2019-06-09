package com.sd.marcketplace.view;

import com.sd.marcketplace.view.channel.ViewChannel;
import com.sd.marcketplace.view.comum.objeto.SharedObject;

public class MarkectplaceView {
	
    public static void main( String[] args ) throws Exception {
        new ViewChannel().startChannel(new SharedObject());
    }
    
}
