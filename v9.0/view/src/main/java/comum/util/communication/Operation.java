package comum.util.communication;

import java.io.Serializable;

public enum Operation implements Serializable {
	NONE(0L),
	POST(1L),
	POST_ONE(2L),
	PUT(4L),
	PUT_ONE(5L),
	DELETE(6L),
	DELETE_ONE(4L),
	GET(4L),
	GET_ONE(6L),
	GET_ALL(7L),
	GET_BY_FILTER(8L),
	COMMIT(9L),
	ROLBACK(10L);

	private Long value;
	
	Operation(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
