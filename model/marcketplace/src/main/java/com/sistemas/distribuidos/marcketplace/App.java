package com.sistemas.distribuidos.marcketplace;

import com.sistemas.distribuidos.marcketplace.config.NetworkAdapter;
import com.sistemas.distribuidos.marcketplace.domain.*;
import com.sistemas.distribuidos.marcketplace.dao.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
    	System.out.println(">>>>>> INICIO DA EXECUCAO <<<<<<<");

    	System.out.println("====== INICIO TESTES DOMAIN ======");
    	// domain
    	Anuncio anuncio = new Anuncio();
    	Comprador comprador = new Comprador();
    	MensagemAnuncio mensagemAnuncio = new MensagemAnuncio();
    	Produto produto = new Produto();
    	Transacao transacao = new Transacao();
    	Usuario usuario = new Usuario();
        System.out.println(usuario);
    	Vendedor vendedor = new Vendedor();
    	System.out.println("====== FIM TESTES DOMAIN ======");

    	System.out.println("====== INICIO TESTES DAO ======");
    	// dao
    	GenericDAO<Anuncio> anuncioDAO = new GenericDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.save(usuario);
    	System.out.println("====== FIM TESTES DAO ======");
    	System.out.println(">>>>>> FIM DA EXECUCAO <<<<<<<");
    }

}
