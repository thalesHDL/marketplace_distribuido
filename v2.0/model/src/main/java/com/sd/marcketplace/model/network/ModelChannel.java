package com.sd.marcketplace.model.network;

import java.util.Collection;
import java.util.Vector;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

public class ModelChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private static final String FILE_CONFIG_CLUSTER = "src/resources/config/cluster/sequencer.xml";
	private static final String CHANNEL_NAME = "Model";

	private JChannel channel;
	private MessageDispatcher despacher;
	
	public ModelChannel() {
		// Empty constructor
	}

	public void run() {
		try {
			startChannel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Função que inicializa a classe, setando o channel e o despacher, e após isto
	 * conectando o chanel a algum canal
	 *
	 * @return void
	 * @param -
	 * @author thales
	 * @version 1.0
	 * @since 2019-05-05
	 **/
	public void startChannel() throws Exception {
		this.channel = new JChannel(FILE_CONFIG_CLUSTER);

		this.despacher = new MessageDispatcher(this.channel, this);

		this.channel.setReceiver(this);
		
		this.channel.connect(CHANNEL_NAME);
		this.eventLoop();
		this.channel.close();
	}

	private void eventLoop() {
		Address meuEndereco = channel.getAddress();

		while (channel.getView().size() < 4)
			Util.sleep(100); // aguarda os membros se juntarem ao cluster

		Vector<Address> cluster = new Vector<Address>(channel.getView().getMembers());
		Address primeiroMembro = cluster.elementAt(0); // 0 a N
		Address segundoMembro = cluster.elementAt(1); // 0 a N
		Address ultimoMembro = cluster.lastElement();

		Vector<Address> grupo = new Vector<Address>();
		grupo.add(segundoMembro);
		grupo.add(ultimoMembro);

		if (meuEndereco.equals(primeiroMembro)) { // somente o primeiro membro envia o teste abaixo

			try {
				enviaUnicast(segundoMembro, "O segundo membro concorda?"); // envia unicast para o primeiro

				enviaAnycast(grupo, "Os membros do grupo concordam?"); // envia anycast para o primeiro e o último

				enviaMulticast("Todos concordam?"); // envia multicast para todos
			} catch (Exception e) {
				System.err.println("ERRO: " + e.toString());
			}

		} // if primeiro
		else {
			while (channel.getView().getMembers().contains(primeiroMembro))
				Util.sleep(100); // aguarda o primeiro membro sair do cluster

			System.out.println("\nBye bye...");
		}
	}

	public void receive(Message msg) { // exibe mensagens recebidas
		System.out.println("" + msg.getSrc() + ": " + msg.getObject());
	}

	public void viewAccepted(View new_view) { // exibe alterações na composição do grupo
		System.out.println("\t** nova View do cluster: " + new_view);
	}

	public Object handle(Message msg) throws Exception {
		String pergunta = (String) msg.getObject();
		System.out.println("RECEBI uma mensagem: " + pergunta + "\n");

		if (pergunta.contains("concorda"))
			return " SIM "; // resposta à requisição contida na mensagem
		else
			return " NÃO ";
	}

	private RspList enviaMulticast(String conteudo) throws Exception {
		System.out.println("\nENVIEI a pergunta: " + conteudo);

		Address cluster = null; // endereço null significa TODOS os membros do cluster
		Message mensagem = new Message(cluster, "{MULTICAST} " + conteudo);

		RequestOptions opcoes = new RequestOptions();
		opcoes.setMode(ResponseMode.GET_ALL); // espera receber a resposta de TODOS membros (ALL, MAJORITY, FIRST, NONE)
		opcoes.setAnycasting(false);

		RspList respList = despacher.castMessage(null, mensagem, opcoes); // MULTICAST
		System.out.println("==> Respostas do cluster ao MULTICAST:\n" + respList + "\n");

		return respList;
	}

	private RspList enviaAnycast(Collection<Address> grupo, String conteudo) throws Exception {
		System.out.println("\nENVIEI a pergunta: " + conteudo);

		Message mensagem = new Message(null, "{ ANYCAST } " + conteudo); // apesar do endereço ser null, se as opcoes
																			// contiverem anycasting==true enviará
																			// somente aos destinos listados

		RequestOptions opcoes = new RequestOptions();
		opcoes.setMode(ResponseMode.GET_MAJORITY); // espera receber a resposta da maioria do grupo (ALL, MAJORITY,
													// FIRST, NONE)
		opcoes.setAnycasting(true);

		RspList respList = despacher.castMessage(grupo, mensagem, opcoes); // ANYCAST
		System.out.println("==> Respostas do grupo ao ANYCAST:\n" + respList + "\n");

		return respList;
	}

	private String enviaUnicast(Address destino, String conteudo) throws Exception {
		System.out.println("\nENVIEI a pergunta: " + conteudo);

		Message mensagem = new Message(destino, "{ UNICAST } " + conteudo);

		RequestOptions opcoes = new RequestOptions();
		opcoes.setMode(ResponseMode.GET_FIRST); // não espera receber a resposta do destino (ALL, MAJORITY, FIRST, NONE)

		String resp = despacher.sendMessage(mensagem, opcoes); // UNICAST
		System.out.println("==> Respostas do membro ao UNICAST:\n" + resp + "\n");

		return resp;
	}

}