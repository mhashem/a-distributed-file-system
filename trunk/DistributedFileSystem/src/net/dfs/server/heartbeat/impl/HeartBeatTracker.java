package net.dfs.server.heartbeat.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.dfs.server.heartbeat.HeartBeatService;
import net.dfs.server.noderegistration.RemoteNodeRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeartBeatTracker {
	
	private static Log log = LogFactory.getLog(HeartBeatTracker.class);
	

	private long lastBeat = -1;
	protected boolean stopped = true;
	private RemoteNodeRegistration registration;
	private String ip;
	private int missed = 0;
	
	
	
	public HeartBeatTracker(RemoteNodeRegistration registration, String ip) {
		super();
		this.registration = registration;
		this.ip = ip;
	}

	public void start() {
		
		
		if (!stopped) throw new IllegalStateException("Already Started");
		
		stopped = false;
		
		new Thread(new Runnable() {
			public void run() {
				
				while (!stopped) {
					
					// Keep track of the time we went 2 sleep
					long sleepTime = System.currentTimeMillis();
					
					
					try {
						Thread.sleep(HeartBeatService.HEART_BEAT_DURATION);
						if (isStopped()) break;
					} catch (InterruptedException e) {
						log.error(e);
					}
					
					
					SimpleDateFormat sdf = new SimpleDateFormat();
					
					log.debug("Checking for Beats (last : " + sdf.format(new Date(lastBeat)) + " | Sleep : " + sdf.format(new Date(sleepTime))+" )");
					
					if (lastBeat < sleepTime) {
						
						log.fatal("Missed Beat (misses :" + (missed+1) + ")");
						
						// missed a beat
						if (++missed > HeartBeatService.MAX_MISSES) {
							log.fatal("HeartBeat Failed for node " + ip);
							if (registration!=null) {
								registration.unregisterNode(ip);
							}
							
							stop();
						}
					}
					else {
						
						// We received a beat in time
						missed = 0;
						
					}
				}
			}
			
		}).start();
	}
	
	public void receivedBeat() {
		lastBeat = System.currentTimeMillis();
		log.debug("Received Beat");
	}
	
	public void stop() {
		this.stopped = true;
	}

	public boolean isStopped() {
		return stopped;
	}

	
}
