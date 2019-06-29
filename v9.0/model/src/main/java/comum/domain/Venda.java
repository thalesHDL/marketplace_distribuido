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
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long qtd;
	private Anuncio anuncio;
	private Usuario consumidor;
}
