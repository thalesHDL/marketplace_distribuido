package comum.domain;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String mensagem;
	private LocalDate data;
	
	private Usuario usuario;
	private Anuncio anuncio;
}
