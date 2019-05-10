package com.sistemas.distribuidos.marcketplace;

import com.sistemas.distribuidos.marcketplace.config.NetworkAdapter;

import org.jgroups.*;
import org.jgroups.blocks.*;
import org.jgroups.util.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        NetworkAdapter networkAdapter = new NetworkAdapter();
        networkAdapter.start();
    }

}
