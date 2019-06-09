package com.sd.marcketplace.visao;

import com.sd.marcketplace.visao.runner.VisaoRunner;

public class MarkectplaceVisao {
	
    public static void main( String[] args ) throws Exception {
    	new Thread(new VisaoRunner()).start();
    }
    
}
