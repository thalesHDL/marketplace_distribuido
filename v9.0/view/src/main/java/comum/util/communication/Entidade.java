package comum.util.communication;

import java.io.Serializable;

public enum Entidade implements Serializable {
	NONE(0L),
	ADDRESS(1L),
	CLUSTER_CONTROLE(2L),
	CLUSTER_MODELO(3L),
	USUARIO(4L),
	PRODUTO(5L),
	VENDA(6L),
	COMENTARIO(7L),
	COMENTARIO_ANUCNIO(8L),
	ANUNCIO(9L);
	
	
	private Long value;
	
	Entidade(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
