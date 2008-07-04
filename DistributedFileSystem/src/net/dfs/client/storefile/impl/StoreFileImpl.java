package net.dfs.client.storefile.impl;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.client.storefile.StoreFile;
import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.impl.LookupImpl;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StoreFileImpl implements StoreFile{
	
	private Lookup lookup;
	private SecurityManager security;
	private FileModel fileTemp;
	private FileCreator creator;
	JavaSpace space;
	private Log log = LogFactory.getLog(StoreFileImpl.class);
	
	public void connectJavaSpace(){
		log.debug("-- ConnectJavaSpce()called ");
		
		String hostname = "localhost";
		
		security.securityManager();

		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();

	}
	
	public void storeFile(){
		
		if(space != null){
			
			for(;;){
				try {
					FileModel received = (FileModel) space.take(fileTemp, null, Long.MAX_VALUE);

					log.debug("--" + received.getName());
					creator.setBufferedOutputStream(received.getName());
					creator.getBufferedOutputStream().write(received.getBytes(),0, received.getBytesRead());
					creator.getBufferedOutputStream().flush();
					creator.getBufferedOutputStream().close();
					
					log.debug("-- File " + received.getName() + " Saved");

				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (UnusableEntryException e) {
					e.printStackTrace();
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else
			log.debug("-- Space is Null...");
	}

	public void setSecurity(SecurityManager security) {
		this.security = security;
	}

	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}

	public void setTempFile(FileModel tempFile) {
		this.fileTemp = tempFile;
	}

	public void setCreator(FileCreator creator) {
		this.creator = creator;
	}
		

}
