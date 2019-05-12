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

    	// domain
    	Anuncio anuncio = new Anuncio();
    	Comprador comprador = new Comprador();
    	MensagemAnuncio mensagemAnuncio = new MensagemAnuncio();
    	Produto produto = new Produto();
    	Transacao transacao = new Transacao();
    	Vendedor vendedor = new Vendedor();

    	// dao
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.save(vendedor);
    	System.out.println(">>>>>> FIM DA EXECUCAO <<<<<<<");
    }

}
