package net.dfs.client.storefile;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.impl.LookupImpl;
import net.dfs.server.filespace.impl.SecurityManagerImpl;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class Store {
	
	Lookup lookup = new LookupImpl();
	JavaSpace space;
	
	public static void main(String args []) {
		Store store = new Store();
		store.connectJavaSpace();
		store.storeFile();
		
	}
	
	public void connectJavaSpace(){
		String hostname = "localhost";
		
		SecurityManager security = new SecurityManagerImpl();
		security.securityM();

		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();

	}
	
	public void storeFile(){
		
		if(space != null){
			
			FileModel tempFile = new FileModel();
			for(;;){
				try {
					FileModel received = (FileModel) space.take(tempFile, null, Long.MAX_VALUE);

					System.out.println(received.getName());
					tempFile.setFout(received.getName());
					tempFile.getFout().write(received.getB(),0, received.getBytesRead());
					tempFile.getFout().flush();
					tempFile.getFout().close();
					
					System.out.println("File " + received.getName() + " Saved");

				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (UnusableEntryException e) {
					e.printStackTrace();
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
			System.out.println("Space is Null...");
	}
}
