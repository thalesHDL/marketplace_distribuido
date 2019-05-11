package com.sistemas.distribuidos.marcketplace.config;

import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;

import org.jgroups.*;
import org.jgroups.blocks.*;
import org.jgroups.util.*;

import java.util.*;

public class NetworkAdapter extends ReceiverAdapter implements RequestHandler {

	JChannel channel;
    MessageDispatcher despacher;

    public NetworkAdapter() {
    	// Empty constructor
    }

    /**
    * Função que inicializa a classe, setando o channel e o despacher, e após isto conectando o chanel a algum canal
    *
    * @return  void
    * @param   -
    * @author  thales
    * @version 1.0
    * @since   2019-05-05
    **/
    public void start() throws Exception {
    	// cria o canal de comunicação que será utilizado para realizar a comunicação entre a rede
    	this.channel = new JChannel(); // alterar para a configuração mais adequada

    	this.despacher = new MessageDispatcher(this.channel, this); // constroi o objeto que será responsavel pela troca de mensagens

    	this.channel.setReceiver(this); // seta a classe "NetworkAdapter" como a classe responsavel com lidar com os pacotes recebidos pelo canal
    	this.channel.connect(MarcketplaceConstantes.CHANNEL_MODEL); // conecta no canal dos models
    		this.eventLoop(); // enquanto a conexao estiver ativa, executar a funcao 'eventLoop'
    	this.channel.close(); // caso a conexao seja perdida fexa a conexao

    }

    private void eventLoop() {
    	// something that the application have to do
    }

    public void receive(Message msg) {
    	// implementa o metodo que recebe a mensagem
    	// do something com a mensagem que receveu
    }

    public Object handle(Message msg) throws Exception {
    	// trata a mensagem que será recebida pelo metodo 'receive'
    	return null;
    }



}