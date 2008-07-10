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

package net.dfs.server.filespace.accessor.impl;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filespace.accessor.FileSpaceAccessor;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileSpaceAccessorImpl implements FileSpaceAccessor {
	
	private FileSpaceCreator spaceCreator;
	private JavaSpace space ;
	private HostAddressCreator addressCreator;
	private Log log = LogFactory.getLog(FileSpaceAccessorImpl.class);
	
	public void fileSpace(){
		

		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
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

	public void writeToSpace(FileStorageModel file){
		
		if(space != null){

		FileStorageModel fileTemp = new FileStorageModel();
				
			try {

				space.write((FileStorageModel)file, null, Long.MAX_VALUE);
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

	public void setSpaceCreator(FileSpaceCreator spaceCreator) {
		this.spaceCreator = spaceCreator;
	}

	public void setAddressCreator(HostAddressCreator addressCreator) {
		this.addressCreator = addressCreator;
	}


}
