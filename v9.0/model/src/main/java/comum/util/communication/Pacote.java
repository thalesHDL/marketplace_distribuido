package comum.util.communication;

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
public class Pacote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Header header;
	private Operation operacao;
	private Entidade entidade;
	private Classe classe;
	private Object content;
	
	public Pacote(Operation operation, Entidade entidade, Classe classe, Object content) {
		super();
		this.operacao = operation;
		this.entidade = entidade;
		this.classe = classe;
		this.content = content;
	}
	
	public Pacote(Operation operation, Entidade entidade, Object content) {
		super();
		this.operacao = operation;
		this.entidade = entidade;
		this.content = content;
	}

}
