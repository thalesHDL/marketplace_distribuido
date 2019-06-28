package comum.util.communication;

import java.io.Serializable;

public enum Status implements Serializable {
	NONE(0L),
	OK(200L),
	RECEBIDO(300L),
	ERROR(400L),
	ADDRESS_INVALIDO(500L);
	
	private Long value;
	
	Status(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
