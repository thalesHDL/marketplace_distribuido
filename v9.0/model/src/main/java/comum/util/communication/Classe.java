package comum.util.communication;

import java.io.Serializable;

public enum Classe implements Serializable {
	NONE(0L),
	VISAO(1L),
	CONTROLE(2L),
	MODELO(3L);
	
	private Long value;
	
	Classe(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
