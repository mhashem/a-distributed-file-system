package net.dfs.server.noderegistration;


public interface UserRegistrationService {

	public void registerUserIP(String fileName, String userIP);

	public String invokeUser(String fileName);
}
