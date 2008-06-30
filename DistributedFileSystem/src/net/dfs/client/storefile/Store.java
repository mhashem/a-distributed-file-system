/**
 * 
 */
package net.dfs.client.storefile;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.impl.LookupImpl;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Rukshan Silva
 *
 */

public class Store {
	
	private Lookup lookup;
	private SecurityManager security;
	private static Store store;
	private FileModel fileTemp;
	JavaSpace space;
	private Log log = LogFactory.getLog(Store.class);

	public static void main(String args []) {
		store.connectJavaSpace();
		store.storeFile();
		
	}
	
	public void connectJavaSpace(){
		String hostname = "localhost";
		
		security.securityM();

		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();

	}
	
	public void storeFile(){
		
		if(space != null){
			
			for(;;){
				try {
					FileModel received = (FileModel) space.take(fileTemp, null, Long.MAX_VALUE);

					log.debug("--" + received.getName());
					fileTemp.setBufferedOutputStream(received.getName());
					fileTemp.getBufferedOutputStream().write(received.getB(),0, received.getBytesRead());
					fileTemp.getBufferedOutputStream().flush();
					fileTemp.getBufferedOutputStream().close();
					
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

	public static void setStore(Store store) {
		Store.store = store;
	}

	public void setTempFile(FileModel tempFile) {
		this.fileTemp = tempFile;
	}
		
}
