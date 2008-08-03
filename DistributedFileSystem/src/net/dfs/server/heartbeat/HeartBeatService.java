package net.dfs.server.heartbeat;

public interface HeartBeatService {
	
	
	public static final long HEART_BEAT_DURATION = 5000;

	public static final int MAX_MISSES = 3;
	
	public void addClient(String ip);
	public void removeClient(String ip);
	public void sendBeat(String ip);
}
