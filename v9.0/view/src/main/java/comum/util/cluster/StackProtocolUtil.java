package comum.util.cluster;

import org.jgroups.protocols.BARRIER;
import org.jgroups.protocols.CENTRAL_LOCK;
import org.jgroups.protocols.FD_ALL2;
import org.jgroups.protocols.FRAG2;
import org.jgroups.protocols.MERGE3;
import org.jgroups.protocols.MPING;
import org.jgroups.protocols.UDP;
import org.jgroups.protocols.UNICAST3;
import org.jgroups.protocols.pbcast.GMS;
import org.jgroups.protocols.pbcast.NAKACK2;
import org.jgroups.protocols.pbcast.STABLE;
import org.jgroups.stack.ProtocolStack;

public final class StackProtocolUtil {
	
	private static final int M_CAST_PORT_VISAO = 9257;
	private static final int M_CAST_PORT_CONTROLE = 9258;
	private static final int M_CAST_PORT_MODELO = 9259;

	public static ProtocolStack protocolView() throws Exception {
		ProtocolStack baseProtocol = new ProtocolStack();
		baseProtocol
			.addProtocol(new UDP()
				.setValue("mcast_port", M_CAST_PORT_VISAO))
			.addProtocol(new MPING()
				.setValue("mcast_port", M_CAST_PORT_VISAO))
			.addProtocol(new MERGE3()
				.setValue("min_interval", 20000)
				.setValue("max_interval", 100000)
				.setValue("max_participants_in_merge", 0))
			.addProtocol(new FD_ALL2()
				.setValue("timeout", 6000)
				.setValue("interval", 5000))
			.addProtocol(new NAKACK2()
				.setValue("log_discard_msgs", false))
			.addProtocol(new GMS()
				.setValue("log_view_warnings", false)
				.setValue("view_bundling", true)
				.setValue("join_timeout", 5000))
			.addProtocol(new FRAG2()
				.setValue("frag_size", 8192));
		return baseProtocol;
	}
	
	public static ProtocolStack protocolController() throws Exception {
		ProtocolStack baseProtocol = new ProtocolStack();
		baseProtocol
			.addProtocol(new UDP()
				.setValue("mcast_port", M_CAST_PORT_CONTROLE))
			.addProtocol(new MPING()
				.setValue("mcast_port", M_CAST_PORT_CONTROLE))
			.addProtocol(new MERGE3()
				.setValue("min_interval", 20000)
				.setValue("max_interval", 100000)
				.setValue("max_participants_in_merge", 0))
			.addProtocol(new FD_ALL2()
					.setValue("timeout", 6000)
					.setValue("interval", 5000))
			.addProtocol(new NAKACK2()
				.setValue("log_discard_msgs", false))
			.addProtocol(new STABLE()
				.setValue("stability_delay", 5000)
				.setValue("max_bytes", 400000)
				.setValue("desired_avg_gossip", 50000))
			.addProtocol(new GMS()
				.setValue("log_view_warnings", false)
				.setValue("view_bundling", true)
				.setValue("join_timeout", 5000))
			.addProtocol(new FRAG2()
					.setValue("frag_size", 8192));
		return baseProtocol;
	}
	
	public static ProtocolStack protocolModel() throws Exception {
		ProtocolStack baseProtocol = new ProtocolStack();
		baseProtocol
			.addProtocol(new UDP()
				.setValue("mcast_port", M_CAST_PORT_MODELO))
			.addProtocol(new MPING()
				.setValue("mcast_port", M_CAST_PORT_MODELO))
			.addProtocol(new MERGE3()
				.setValue("min_interval", 20000)
				.setValue("max_interval", 100000)
				.setValue("max_participants_in_merge", 0))
			.addProtocol(new FD_ALL2()
					.setValue("timeout", 6000)
					.setValue("interval", 5000))
			.addProtocol(new NAKACK2()
				.setValue("log_discard_msgs", false))
			.addProtocol(new STABLE()
				.setValue("stability_delay", 5000)
				.setValue("max_bytes", 400000)
				.setValue("desired_avg_gossip", 50000))
			.addProtocol(new GMS()
				.setValue("log_view_warnings", false)
				.setValue("view_bundling", true)
				.setValue("join_timeout", 5000))
			.addProtocol(new CENTRAL_LOCK())
			.addProtocol(new FRAG2()
					.setValue("frag_size", 8192));
		return baseProtocol;
	}	
}
	
