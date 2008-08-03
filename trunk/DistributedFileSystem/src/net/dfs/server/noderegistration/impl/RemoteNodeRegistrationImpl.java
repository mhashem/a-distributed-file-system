package net.dfs.server.noderegistration.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import net.dfs.server.heartbeat.HeartBeatService;
import net.dfs.server.noderegistration.RemoteNodeRegistration;
import net.dfs.ui.ServerUI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RemoteNodeRegistrationImpl implements RemoteNodeRegistration{
	
	private Log log = LogFactory.getLog(RemoteNodeRegistrationImpl.class);
	private Map<String, String> nodeRegistration = new HashMap<String, String>();

	private HeartBeatService heartBeatService;
	
	
	
	public void setHeartBeatService(HeartBeatService heartBeatService) {
		this.heartBeatService = heartBeatService;
	}



	public String registerNode(final String client) throws UnknownHostException {
		
		new Thread(new Runnable(){
			public void run(){
				
				nodeRegistration.put(client, "CONNECTED");
				heartBeatService.addClient(client);
				
				ServerUI.setClients(nodeRegistration.size());
				log.info("Node Registered - "+ client);
			}
		}).start();
		return InetAddress.getLocalHost().getHostName();
	}



	public void unregisterNode(final String ip) {
		
		new Thread(new Runnable(){
			public void run(){
				
				heartBeatService.removeClient(ip);
				nodeRegistration.remove(ip);
				
				ServerUI.setClients(nodeRegistration.size());
				log.error("Node Unregistered - "+ ip);
			}
		}).start();
	}
	
	public boolean isConnected(String ip){
		boolean state = false;

		if(nodeRegistration.get(ip) == "CONNECTED"){
			state = true;
		}
		return state;
	}
}
