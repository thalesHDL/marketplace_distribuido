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
	GET(5L),
	GET_BY_ID(6L),
	GET_ONE(7L),
	GET_ALL(8L),
	GET_BY_FILTER(9L),
	COMMIT(10L),
	ROLBACK(11L);

	private Long value;
	
	Operation(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
