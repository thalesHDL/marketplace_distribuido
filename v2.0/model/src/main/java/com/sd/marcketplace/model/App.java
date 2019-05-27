package com.sd.marcketplace.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sd.marcketplace.model.network.ModelChannel;

@SpringBootApplication
public class App {
	
    public static void main( String[] args ) throws Exception {
        new Thread(new ModelChannel()).start();
    }

}