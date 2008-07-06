package net.dfs.server.filespace.creator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpaceHost extends Remote{
	
	public String getHostAddress()throws RemoteException;
}
