package net.dfs.server.noderegistration;

import java.net.InetAddress;

public interface NodeRegistrationService {
	
	public void registerNode(InetAddress client);
}
