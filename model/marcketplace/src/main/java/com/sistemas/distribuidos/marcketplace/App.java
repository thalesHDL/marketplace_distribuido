package com.sistemas.distribuidos.marcketplace;

import com.sistemas.distribuidos.marcketplace.network.NetworkAdapter;
import com.sistemas.distribuidos.marcketplace.domain.*;
import com.sistemas.distribuidos.marcketplace.dao.*;
import java.util.List;

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
        Usuario usuario = new Usuario();
    	Vendedor vendedor = new Vendedor();

    	// dao
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        CompradorDAO compradorDAO = new CompradorDAO();
        MensagemAnuncioDAO mensagemAnuncioDAO = new MensagemAnuncioDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        // dao - save
        anuncioDAO.save(anuncio);
        compradorDAO.save(comprador);
        mensagemAnuncioDAO.save(mensagemAnuncio);
        produtoDAO.save(produto);
        transacaoDAO.save(transacao);
        vendedorDAO.save(vendedor);
        // dao - getAll
        List<Anuncio> listAnuncio = anuncioDAO.getAll();
        List<Comprador> listComprador = compradorDAO.getAll();
        List<MensagemAnuncio> listMensagemAnuncio = mensagemAnuncioDAO.getAll();
        List<Produto> listProduto = produtoDAO.getAll();
        List<Transacao> listTransacao = transacaoDAO.getAll();
        List<Vendedor> listVendedor = vendedorDAO.getAll();

    	System.out.println(">>>>>>> FIM DA EXECUCAO <<<<<<<<<");
    }

}
