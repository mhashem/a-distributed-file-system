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

package net.dfs.server.filespace.creator.impl;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.creator.FileSpace;
import net.dfs.server.filespace.creator.SecurityManager;
import net.dfs.server.filespace.creator.SpaceAccessor;
import net.dfs.server.filespace.creator.SpaceHost;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileSpaceImpl implements FileSpace {
	
	private SpaceAccessor lookup;
	private JavaSpace space ;
	private SpaceHost spaceHost;
	private Log log = LogFactory.getLog(FileSpaceImpl.class);
	
	public void fileSpace(){
		

		try {
			space = lookup.getSpace(spaceHost.getHostAddress());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


/*		try {
			FileListenerImpl listener = new FileListenerImpl(space);
			FileModel model = new FileModel();
			space.notify(model,null,listener,Long.MAX_VALUE, null);

		} catch (RemoteException e) {
			System.out.println("EX 1 !!!");
			e.printStackTrace();
		} catch (TransactionException e) {
			System.out.println("EX 2 !!!");
			e.printStackTrace();
		}
*/		
	}

	public void writeToSpace(FileModel file){
		
		if(space != null){

		FileModel fileTemp = new FileModel();
				
			try {

				space.write((FileModel)file, null, Long.MAX_VALUE);
				log.debug("-- File " + file.fileName + " Written to the Space");

//				FileModel received = (FileModel) space.take((FileModel)fileTemp, null, Long.MAX_VALUE);

//				log.debug("-- File " + received.fileName + " Reading from the Space");
//				log.debug("-- Bytes " + received.bytesRead + " Reading from the Space");

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

	public void setLookup(SpaceAccessor lookup) {
		this.lookup = lookup;
	}

	public void setSpaceHost(SpaceHost spaceHost) {
		this.spaceHost = spaceHost;
	}
	
}
