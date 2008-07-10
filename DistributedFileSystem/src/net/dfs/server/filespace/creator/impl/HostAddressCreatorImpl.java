package net.dfs.server.filespace.creator.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;

import net.dfs.server.filespace.creator.HostAddressCreator;

public class HostAddressCreatorImpl implements HostAddressCreator{

	public String getHostAddress() {
		
		String host = null;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		return host;
	}

}
