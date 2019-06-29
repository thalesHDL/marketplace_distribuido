package comum.domain;

import java.io.Serializable;

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
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String msg;
	private Usuario usuario;
}
