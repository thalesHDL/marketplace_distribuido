package comum.util.cluster;

import java.util.List;

import org.jgroups.Address;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;

public class Opcoes {

	RequestOptions opcoes = null;
	
	public Opcoes(ResponseMode responseMode, boolean anycast, List<Address> exclusao){
		opcoes = new RequestOptions();
		opcoes.setAnycasting(anycast);
		opcoes.setMode(responseMode);
		opcoes.setExclusionList(exclusao.stream().toArray(Address[]::new));
	}
	
	public Opcoes(ResponseMode responseMode, boolean anycast, Address exclusao){
		opcoes = new RequestOptions();
		opcoes.setAnycasting(anycast);
		opcoes.setMode(responseMode);
		opcoes.setExclusionList(exclusao);
	}
	
	public Opcoes(ResponseMode responseMode, boolean anycast){
		opcoes = new RequestOptions();
		opcoes.setAnycasting(anycast);
		opcoes.setMode(responseMode);
	}
	
	public Opcoes(ResponseMode responseMode) {
		opcoes = new RequestOptions();
		opcoes.setMode(responseMode);
	}
	
	public RequestOptions getOptions(){
		return opcoes;
	}

}
