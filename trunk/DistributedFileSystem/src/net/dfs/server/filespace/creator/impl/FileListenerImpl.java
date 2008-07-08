package net.dfs.server.filespace.creator.impl;

import java.io.Serializable;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.event.RemoteEvent;
import net.jini.core.event.RemoteEventListener;
import net.jini.core.event.UnknownEventException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class FileListenerImpl implements RemoteEventListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JavaSpace space;
	
	public FileListenerImpl(JavaSpace space){
	
		System.out.println("FILE LISTENER CALLED !!!");
		this.space = space;
/*		try {
			UnicastRemoteObject.exportObject(this,0);
			System.out.println("UnicastRemoteObject DONE !!!");
		} catch (RemoteException e) {
			System.out.println("EXCEPTION !!!");
			e.printStackTrace();
		}
*/	}
	
	public void notify(RemoteEvent event) throws UnknownEventException,
			RemoteException {
		FileModel temp = new FileModel();
		
		try {
			FileModel result = (FileModel) space.read(temp, null, Long.MAX_VALUE);
		
			System.out.println(result.fileName);
		} catch (UnusableEntryException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION 1 !!!");
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION 2 !!!");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION 3 !!!");
			e.printStackTrace();
		}
		
		
	}

}
