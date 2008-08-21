package net.dfs.server.heartbeat.impl;

import java.util.HashMap;
import java.util.Map;

import net.dfs.server.heartbeat.HeartBeatService;
import net.dfs.server.noderegistration.RemoteNodeRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeartBeatServiceImpl implements HeartBeatService {

	private static Log log = LogFactory.getLog(HeartBeatServiceImpl.class);
	private Map<String, HeartBeatTracker> trackers = new HashMap<String, HeartBeatTracker>();
	private RemoteNodeRegistration nodeRegistration;
	
	public void sendBeat(String ip) {
		
		if (trackers.containsKey(ip)) {
			trackers.get(ip).receivedBeat();
		} 
	}

	public synchronized void addClient(String ip) {
		if (!trackers.containsKey(ip)) {
			
			HeartBeatTracker tracker = new HeartBeatTracker(nodeRegistration, ip);
			trackers.put(ip, tracker);
			log.debug("Client "+ip+" added to the HeartBeat Service");

			tracker.start();
		}
	}

	public synchronized void removeClient(String ip) {
		if (trackers.containsKey(ip)) {
			HeartBeatTracker tracker = trackers.remove(ip);
			tracker.stop();
		}		
	}

	public void setNodeRegistration(RemoteNodeRegistration nodeRegistration) {
		this.nodeRegistration = nodeRegistration;
	}


}
