package comum.util.cluster.exception;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.Address;

public class UtilException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<Address> rolbackList;
	
	
	public UtilException() {
        super();
        this.rolbackList = new ArrayList<Address>();
    }
	
	public UtilException(String msg) {
		super(msg);
		this.rolbackList = new ArrayList<Address>();
	}
	
	public UtilException(List<Address> rolbackList) {
		super();
		this.rolbackList = rolbackList;
	}
	
	public UtilException(List<Address> rolbackList, String msg) {
		super(msg);
		this.rolbackList = rolbackList;
	}
	
	public List<Address> getRolbackList() {
		return this.rolbackList;
	}

}
