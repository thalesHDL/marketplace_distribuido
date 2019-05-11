package com.sistemas.distribuidos.marcketplace;

import com.sistemas.distribuidos.marcketplace.config.NetworkAdapter;
import com.sistemas.distribuidos.marcketplace.domain.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {
    	Anuncio anuncio = new Anuncio();
    	Comprador comprador = new Comprador();
    	MensagemAnuncio mensagemAnuncio = new MensagemAnuncio();
    	Produto produto = new Produto();
    	Transacao transacao = new Transacao();
    	Usuario usuario = new Usuario();
    	Vendedor vendedor = new Vendedor();
    }

}
