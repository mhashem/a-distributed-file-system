package net.dfs.remote.heartbeat;

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import net.dfs.server.heartbeat.HeartBeatService;

public class HeartBeatSender implements InitializingBean {

	private HeartBeatService service;
	private static Log log = LogFactory.getLog(HeartBeatSender.class);
	private String ip;
	private boolean stopped = true;

	public void start() {

		stopped = false;
		
		new Thread(new Runnable() {
			public void run() {

				while (!stopped) {
					if (service != null) {
						try {
							service.sendBeat(ip);
						} catch (Exception e) {
							log.error(e);
						}

						try {
							Thread.sleep(HeartBeatService.HEART_BEAT_DURATION);
						} catch (InterruptedException e) {
							log.error(e);
						}
					}
				}
			}

		}).start();
	}
	
	public void stop() {
		stopped = true;
	}

	public boolean isStopped() {
		return stopped;
	}



	public void afterPropertiesSet() throws Exception {
		ip = InetAddress.getLocalHost().getHostAddress();
		start();
	}
	
	
	public void setService(HeartBeatService service) {
		this.service = service;
	}
}
