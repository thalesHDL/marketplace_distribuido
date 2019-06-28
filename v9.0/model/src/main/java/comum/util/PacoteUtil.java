package comum.util;

import comum.util.communication.Pacote;

public final class PacoteUtil {

	public static Pacote createPacoteError(String msg) {
		Pacote pacote = new Pacote();
		pacote.setHeader(HeaderUtil.createHeaderError(msg));
		return pacote;
	}
	
	public static Pacote createPacoteError(String msg, String identifier) {
		Pacote pacote = new Pacote();
		pacote.setHeader(HeaderUtil.createHeaderError(msg));
		return pacote;
	}
	
	public static Pacote createPacoteRecebido(Object content, String identifier) {
		Pacote pacote = new Pacote();
		pacote.setContent(content);
		pacote.setHeader(HeaderUtil.createHeaderRecebido(identifier));
		return pacote;
	}
	
}
