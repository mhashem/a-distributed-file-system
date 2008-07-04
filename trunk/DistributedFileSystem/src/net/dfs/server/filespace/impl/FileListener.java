package net.dfs.server.filespace.impl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.dfs.server.filemodel.FileModel;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.event.RemoteEvent;
import net.jini.core.event.RemoteEventListener;
import net.jini.core.event.UnknownEventException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class FileListener implements RemoteEventListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JavaSpace space;
	
	public FileListener(JavaSpace space){
		this.space = space;
		try {
			UnicastRemoteObject.exportObject(this,0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void notify(RemoteEvent event) throws UnknownEventException,
			RemoteException {
		FileModel temp = new FileModel();
		
		try {
			FileModel result = (FileModel) space.read(temp, null, Long.MAX_VALUE);
		
			System.out.println(result.getName());
		} catch (UnusableEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
