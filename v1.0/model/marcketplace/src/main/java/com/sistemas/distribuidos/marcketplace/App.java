package com.sistemas.distribuidos.marcketplace;


import com.sistemas.distribuidos.marcketplace.network.ModelChannel;
import com.sistemas.distribuidos.marcketplace.network.ModelControllerChannel;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
    	System.out.println(">>>>>> INICIO DA EXECUCAO <<<<<<<");
        new ModelChannel().startChannel();
        new ModelControllerChannel().startChannel();
    	System.out.println(">>>>>>> FIM DA EXECUCAO <<<<<<<<<");
    }

}
