package comum.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Anuncio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private BigDecimal preco;
	private Long quantidade;
	
	private Produto produto;
	private Usuario vendedor;
}
