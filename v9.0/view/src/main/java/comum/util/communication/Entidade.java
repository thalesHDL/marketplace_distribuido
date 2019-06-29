package comum.util.communication;

import java.io.Serializable;

public enum Entidade implements Serializable {
	NONE(0L),
	ADDRESS(1L),
	CLUSTER_CONTROLE(2L),
	CLUSTER_MODELO(3L),
	USUARIO(4L),
	VENDEDOR(5L),
	CONSUMIDOR(6L),
	PRODUTO(7L),
	VENDA(8L),
	COMENTARIO(9L),
	COMENTARIO_ANUCNIO(10L),
	ANUNCIO(11L);
	
	
	private Long value;
	
	Entidade(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
