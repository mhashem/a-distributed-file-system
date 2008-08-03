package net.dfs.server.noderegistration;

import java.net.UnknownHostException;


public interface RemoteNodeRegistration {
	
	public String registerNode(final String client) throws UnknownHostException;
	public void unregisterNode(String ip);
	public boolean isConnected(String ip);

}
