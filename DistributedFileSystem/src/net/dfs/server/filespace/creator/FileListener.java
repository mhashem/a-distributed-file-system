package net.dfs.server.filespace.creator;

import java.rmi.RemoteException;

import net.jini.core.event.RemoteEvent;
import net.jini.core.event.UnknownEventException;

public interface FileListener {

	public void notify(RemoteEvent event) throws UnknownEventException,RemoteException;

}
