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

/**
 * @author Rukshan
 *
 */
public class FileSpaceImpl implements FileSpace {
	
	private SecurityManager security;
	private Lookup lookup;
	private JavaSpace space ;
	
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
					System.out.println("File " + file.getName() + " written to the Space");
			//	}	
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			// we were unable to find the JavaSpaces service specified
			System.out.println("Unable to find ");
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
