package comum.util;

import comum.domain.Usuario;
import comum.util.communication.Header;
import comum.util.communication.Pacote;
import comum.util.communication.Status;

public final class HeaderUtil {

	public static Header createHeaderEnvio(Usuario usuario, String token, Pacote pacote) {
		String msg = "[ENVIANDO]" + pacote.getOperacao().toString() + " - " + pacote.getEntidade().toString() + " : ";
		if (pacote.getContent() == null) {
			msg = msg + "null";
		} else {
			msg = msg + pacote.getContent().toString();
		}
		return new Header(usuario, Status.OK, msg, token);
	}
	
	public static Header createHeaderError(String msg) {
		return new Header(null, Status.ERROR, msg, null);
	}
	
	public static Header createHeaderRecebido() {
		return new Header(null, Status.RECEBIDO, null, null);
	}
	
	public static Header createHeaderError(String msg, String identifier) {
		return new Header(null, Status.ERROR, msg, identifier);
	}
	
	public static Header createHeaderRecebido(String identifier) {
		return new Header(null, Status.RECEBIDO, null, identifier);
	}
	
}
