package com.sd.marcketplace.controle;

import com.sd.marcketplace.controle.comum.objeto.SharedObject;
import com.sd.marcketplace.controle.recursos.ControleChannel;
import com.sd.marcketplace.controle.recursos.VisaoChannel;

public class MarkectplaceControle {
	
    public static void main( String[] args ) throws Exception {
    	SharedObject sharedObj = new SharedObject();
//    	new ControleChannel().initChannel(sharedObj);
    	try {
    		new VisaoChannel().initChannel(sharedObj);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    }
    
}
