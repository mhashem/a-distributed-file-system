/**
 * Copyright 2008 Rukshan Silva
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations 
 * under the License.
 */

package net.dfs.server.filespace.impl;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.FileSpace;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.jini.core.entry.Entry;
import net.jini.core.lease.Lease;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileSpaceImpl implements FileSpace {
	
	private SecurityManager security;
	private Lookup lookup;
	private JavaSpace space ;
	private Log log = LogFactory.getLog(FileSpaceImpl.class);
	
	public void fileSpace(){
		
		String hostname = "localhost";
		
		security.securityManager();
		
		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();

		try {
			FileListener listener = new FileListener(space);
			FileModel model = new FileModel();
			space.notify(model,null,listener,Lease.FOREVER, null);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		
	}

	public void writeToSpace(FileModel file){
		
		if(space != null){
							
			try {
				//while(System.in.read() > 0){
				space.write((Entry) file, null, Long.MAX_VALUE);
				//	log.debug("-- File " + file.getName() + " written to the Space");
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
