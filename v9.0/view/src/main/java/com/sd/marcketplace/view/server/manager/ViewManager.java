package com.sd.marcketplace.view.server.manager;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.View;

import com.sd.marcketplace.view.server.receiver.ControllerReceiver;

import comum.util.Util;
import comum.util.cluster.Constantes;
import comum.util.cluster.StackProtocolUtil;

public class ViewManager extends ControllerReceiver {
	
	protected ViewManager() {
		// Empty constructor
	}
	
	protected void initChannelView() {
		try {
			viewChannel = new JChannel(false);
			viewChannel.setProtocolStack(StackProtocolUtil.protocolView());
			viewChannel.getProtocolStack().init();
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void initViewMembershipListner() {
		viewDispatcher.setMembershipListener(this);
	}
	
	protected void connectView() {
		try {
			viewChannel.connect(Constantes.CHANNEL_NAME_VIEW);
		} catch (Exception e) {
			// TODO: tratar exception
			e.printStackTrace();
		}
	}
	
	protected void desconnectView() {
		viewChannel.close();
	}
	
	@Override
	public void viewAccepted(View view) {
		Util.print(view.toString());
		if (view.compareTo(viewChannel.getView()) == Constantes.VIEW_COMPARE_TO_EQUALS) {
			membershipListenerView(view);
		} else {
			membershipListenerController(view);
		}
    }
	
	@Override
	public void suspect(Address mbr) {
		if (viewChannel.getView().getMembers().contains(mbr)) {
			viewSuspect(mbr);
		} else {
			controllerSuspect(mbr);
		}
    }
	
	public void membershipListenerView(View view) {
		// TODO
	}
	
	public void viewSuspect(Address mbr) {
		// TODO
	}

}
