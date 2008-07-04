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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filemodel.Message;
import net.dfs.server.filespace.FileSpace;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lease.Lease;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Temp implements FileSpace {
	
	private SecurityManager security;
	private Lookup lookup;
	private JavaSpace space ;
	private Log log = LogFactory.getLog(FileSpaceImpl.class);
	FileModel fileTemp;
	
	public void fileSpace(){
		
		String hostname = "localhost";
		
		security.securityManager();
		
		((LookupImpl) lookup).setHostname(hostname);

		space = lookup.getSpace();

//		try {
//			FileListener listener = new FileListener(space);
//			FileModel model = new FileModel();
//			space.notify(model,null,listener,Lease.FOREVER, null);
/*
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
*/		
	}

	public void writeToSpace(FileModel file){
		
		if(space != null){
							
			String line;
			BufferedReader reader = new BufferedReader(new
			InputStreamReader(System.in));
			// create a message entry
			Message msg = new Message();
			// while console input available
			try {
				while ((line = reader.readLine()).length() > 0) {
					// set the message text
					msg.text = line;
					// write a message per line entered
					space.write(msg, null, Long.MAX_VALUE);	
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
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
