package comum.util.communication;

import java.io.Serializable;

public enum Node implements Serializable {
	VIEW(0L),
	CONTROLLER(1L),
	MODEL(2L);
	
	private Long value;
	
	Node(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
