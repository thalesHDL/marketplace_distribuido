package com.sd.marcketplace.modelo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sd.marcketplace.modelo.domain.Produto;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.sd.marcketplace.modelo.repository"})
@EntityScan(basePackages = {"com.sd.marcketplace.modelo.domain"})
public class App {
    
	public static void main( String[] args ) {
        Produto p = new Produto();
    }
	
}
