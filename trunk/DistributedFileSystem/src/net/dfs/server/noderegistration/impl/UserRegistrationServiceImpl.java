package net.dfs.server.noderegistration.impl;

import java.util.HashMap;
import java.util.Map;

import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.ui.ServerUI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	private Log log = LogFactory.getLog(UserRegistrationServiceImpl.class);
	private Map<String, String> userIPs = new HashMap<String, String>();

	// FIXME When a user saves a file, call this method - FIXED
	public void registerUserIP(String fileName, String userIP) {
		userIPs.put(fileName, userIP);
		ServerUI.setUsers(userIPs.size());
		log.debug("The File : "+fileName+" is sent by the User "+userIP);
	}
	
	public String invokeUser(String fileName){
		log.debug("The User : "+userIPs.get(fileName)+" holds the File "+fileName);
		return userIPs.get(fileName);
	}
}
