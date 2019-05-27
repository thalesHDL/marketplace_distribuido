package com.sd.marcketplace.view.network;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;

import java.nio.file.FileSystems;
import java.util.Scanner;

public class ViewChannel extends ReceiverAdapter implements RequestHandler, Runnable {
	
	private static final String FILE_CONFIG_CLUSTER = "src/resources/config/cluster/sequencer.xml";
	private static final String CHANNEL_NAME = "View";
	
	private static final int CADASTRAR = 1;
	private static final int COMPRAR = 2;
	private static final int ENVIAR_MENSAGEM = 3;
	private static final int SAIR = 4;
	
	private JChannel channel;
	private MessageDispatcher despacher;
	
	
	public ViewChannel() {
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
		Scanner ler = new Scanner(System.in);
		
		int opcao = 0;
		while (opcao != SAIR) {
			System.out.print(mountMenu());
			opcao = Integer.parseInt(ler.next());
		}
	}
	
	private static String getPath() {
		String path = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
		return path.substring(0, path.length());
	}
	
	private static String mountMenu() {
		String menu = "";
		menu = menu.concat("/*******************************************************************/\n");
		menu = menu.concat("/**                                                               **/\n");
		menu = menu.concat("/** 1) Cadastrar produto                                          **/\n");
		menu = menu.concat("/** 2) Comprar produto                                            **/\n");
		menu = menu.concat("/** 3) Enviar mensagem sobre produto                              **/\n");
		menu = menu.concat("/** 4) Sair                                                       **/\n");
		menu = menu.concat("/**                                                               **/\n");
		menu = menu.concat("/*******************************************************************/\n");
		menu = menu.concat("escolha: ");
		return menu;
	}
	
	
	
	
	public Object handle(Message msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
