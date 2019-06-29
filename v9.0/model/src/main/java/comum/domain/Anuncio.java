package comum.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Anuncio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String desc;
	private BigDecimal preco;
	private Long qtd;
	
	private Produto produto;
	private Usuario vendedor;
}
