package com.sd.marcketplace.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sd.marcketplace.model.server.Server;

@SpringBootApplication
public class App extends Server {
	
	
    @SuppressWarnings("unused")
	public static void main( String[] args ) {
    	ApplicationContext context = SpringApplication.run(App.class,args);
    }
    
    @Bean
	public CommandLineRunner start() {
		return (args) -> {
			init();			
		};
	}
    
    
    
    
}
