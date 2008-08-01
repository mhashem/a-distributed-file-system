package net.dfs.server.noderegistration;

import java.net.InetAddress;

public interface RemoteNodeRegistration {
	
	public void registerNode(InetAddress client);
}
