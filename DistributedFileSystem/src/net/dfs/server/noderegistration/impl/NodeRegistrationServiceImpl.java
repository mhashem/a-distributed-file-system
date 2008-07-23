package net.dfs.server.noderegistration.impl;

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.noderegistration.NodeRegistrationService;

public class NodeRegistrationServiceImpl implements NodeRegistrationService{
	private Log log = LogFactory.getLog(NodeRegistrationServiceImpl.class);

	public void registerNode(InetAddress client) {
		log.info("Node Registered - "+ client.getHostAddress());
	}

}
