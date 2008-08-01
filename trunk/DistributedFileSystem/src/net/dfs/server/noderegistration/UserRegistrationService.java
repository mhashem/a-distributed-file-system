package net.dfs.server.noderegistration;

import java.net.InetAddress;

public interface UserRegistrationService {

	public void registerUserIP(String fileName, InetAddress userIP);

	public String invokeUser(String fileName);
}
