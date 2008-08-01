package net.dfs.server.noderegistration.impl;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.noderegistration.UserRegistrationService;

public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	private Log log = LogFactory.getLog(UserRegistrationServiceImpl.class);
	private Map<String, String> userIPs = new HashMap<String, String>();

	// FIXME When a user saves a file, call this method
	public void registerUserIP(String fileName, InetAddress userIP) {
		userIPs.put(fileName, userIP.getHostAddress());
		log.debug("The File : "+fileName+" By User "+userIP.getHostAddress()+" Added to the map");
	}
	
	public String invokeUser(String fileName){
		log.debug("The File : "+fileName+" Taken from the map");
		return userIPs.get(fileName);
	}
}
