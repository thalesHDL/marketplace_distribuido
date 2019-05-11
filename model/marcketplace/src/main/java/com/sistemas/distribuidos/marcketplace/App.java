package com.sistemas.distribuidos.marcketplace;

import com.sistemas.distribuidos.marcketplace.config.NetworkAdapter;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
        new NetworkAdapter().start();
    }

}
