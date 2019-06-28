package comum.util.communication;

import java.io.Serializable;

import comum.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Header implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	private Status status;
	private String msg;
	private String token;

}
