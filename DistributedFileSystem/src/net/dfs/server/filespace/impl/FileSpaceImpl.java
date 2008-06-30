/**
 * 
 */
package net.dfs.server.filespace.impl;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.FileSpace;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.jini.core.entry.Entry;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Rukshan Silva
 *
 */
public class FileSpaceImpl implements FileSpace {
	
	private SecurityManager security;
	private Lookup lookup;
	private JavaSpace space ;
	private Log log = LogFactory.getLog(FileSpaceImpl.class);
	
	public void fileSpace(){

		String hostname = "localhost";
		
		security.securityM();
		
		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();
	}

	public void writeToSpace(FileModel file){
		
		if(space != null){
							
			try {
				//while(System.in.read() > 0){
					space.write((Entry) file, null, Long.MAX_VALUE);
					log.debug("-- File " + file.getName() + " written to the Space");
			//	}	
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			log.debug("-- Unable to find ");
			System.exit(1);
		}

	}

	public void setSecurity(SecurityManager security) {
		this.security = security;
	}

	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}
	
}
