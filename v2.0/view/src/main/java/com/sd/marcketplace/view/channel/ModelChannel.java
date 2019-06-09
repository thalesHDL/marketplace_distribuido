package com.sd.marcketplace.view.channel;


public class ModelChannel {
	
//	private JChannel channel;
//	private MessageDispatcher despacher;
//	private SharedMessage sharedMessage;
//	
//	public ModelChannel() {
//		// Empty constructor
//	}
//	
//	public ModelChannel(SharedMessage sharedMessage) {
//		this.sharedMessage = sharedMessage;
//	}
//	
//	public void run() {
//		try {
//			startChannel();
//		} catch (Exception e) {
//			e.printStackTrace();
//			Thread.currentThread().interrupt();
//		}
//	}
//	
//	/**
//	 * Função que inicializa a classe, setando o channel e o despacher, e após isto
//	 * conectando o chanel a algum canal
//	 *
//	 * @return void
//	 * @param -
//	 * @author thales
//	 * @version 1.0
//	 * @since 2019-05-05
//	 **/
//	public void startChannel() throws Exception {
//		this.channel = new JChannel(Constantes.FILE_CONFIG_CLUSTER);
//
//		this.despacher = new MessageDispatcher(this.channel, this);
//
//		this.channel.setReceiver(this);
//		
//		this.channel.connect(Constantes.MODEL_CHANNEL_NAME);
//		this.eventLoop();
//		this.channel.close();
//	}
//	
//	public void eventLoop() throws InterruptedException {
//		int t = 0;
//		int t2 = 1;
//		while(t != t2) {
//			if(!this.sharedMessage.getAction().equals(Action.NONE)) {
//				this.trataRequest();
//			}
//			sleep(1000);
//		}
//	}
	
	
	
	
	
//	private void trataRequest() {
//		if(this.sharedMessage.getAction().equals(Action.POST)) {
//			this.cadastrarProduto();
//		}
//	}
//	
//	private void cadastrarProduto() {
//		try {
//			this.enviaMulticast(new Message(null, this.sharedMessage.getContent()));
//			this.sharedMessage.finishAction();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	
	
	
	
	
//	private void enviaMulticast(Message msg) throws Exception {
//		RequestOptions opcoes = new RequestOptions(); 
//        opcoes.setMode(ResponseMode.GET_ALL);
//        opcoes.setAnycasting(false);
//        Object retorno = this.despacher.castMessage(null, msg, opcoes);
//        System.out.println("[MODEL] retorno multicast: ".concat(retorno.toString()));
//	}
//	
//	private static void sleep(int time) throws InterruptedException {
//		Thread.currentThread();
//		Thread.sleep(time);
//	}
	
	
	
	
	
	
	
	
//	public Object handle(Message msg) throws Exception {
//		System.out.println("[MODEL] handle message: ".concat(msg.getObject().toString()));
//		return true;
//	}
//	
//	public void receive(Message msg) {
//		System.out.println("[MODEL] receive message: " + msg.getSrc() + ": " + msg.getObject());
//	}

}
