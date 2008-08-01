package net.dfs.server.noderegistration.impl;

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.noderegistration.RemoteNodeRegistration;

public class RemoteNodeRegistrationImpl implements RemoteNodeRegistration{
	private Log log = LogFactory.getLog(RemoteNodeRegistrationImpl.class);

	public void registerNode(InetAddress client) {
		log.info("Node Registered - "+ client.getHostAddress());
	}

}
