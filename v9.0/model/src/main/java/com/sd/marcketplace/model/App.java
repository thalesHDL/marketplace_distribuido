package com.sd.marcketplace.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sd.marcketplace.model.server.Server;

@SpringBootApplication
public class App extends Server implements CommandLineRunner {
	
	public static void main( String[] args ) {
        SpringApplication app = new SpringApplication(App.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    public void run(String... args) throws Exception {
    	init();	
    }
}
