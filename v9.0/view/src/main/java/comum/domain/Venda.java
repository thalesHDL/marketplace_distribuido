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
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long quantidade;
	private LocalDate data;
	private Anuncio anuncio;
	private Usuario consumidor;
}
