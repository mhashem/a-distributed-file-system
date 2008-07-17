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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filespace.accessor.WriteSpaceAccessor;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the {@link WriteSpaceAccessor} which will be create a Space in 
 * the local Server and the File objects will be written to the Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class WriteSpaceAccessorImpl implements WriteSpaceAccessor {
	
	private FileSpaceCreator spaceCreator;
	private JavaSpace space ;
	private HostAddressCreator addressCreator;
	private Log log = LogFactory.getLog(WriteSpaceAccessorImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void fileSpace(){
		
		try {
			if(space == null){
				space = spaceCreator.getSpace(addressCreator.getHostAddress(), InetAddress.getLocalHost());
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
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

	/**
	 * writeToSPace will write a File object to the newly created local Space. It
	 * makes sure the Space is not null before the File objects are been written to the 
	 * Space.
	 * <p>
	 * It returns no value and throws RemoteException or TransactionException on a failure.
	 * 
	 * @param file is an object of the type {@link FileStorageModel}
	 */
	public void writeToSpace(FileStorageModel file){
		
		if(space != null){

			try {
				space.write((FileStorageModel)file, null, Long.MAX_VALUE);
				log.info("File "+file.fileName+" with "+file.bytesRead+" bytes Written to the Space");

			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (TransactionException e) {
				e.printStackTrace();
			}	
		}
		else{
			fileSpace();
		}
	}
	
	/**
	 * setSpaceCreator will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileSpaceCreator}
	 * 
	 * @param spaceCreator is an object of type {@link FileSpaceCreator}
	 */
	public void setSpaceCreator(FileSpaceCreator spaceCreator) {
		this.spaceCreator = spaceCreator;
	}

	/**
	 * setAddressCreator will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link HostAddressCreator}
	 * 
	 * @param addressCreator is an object of type {@link HostAddressCreator}
	 */
	public void setAddressCreator(HostAddressCreator addressCreator) {
		this.addressCreator = addressCreator;
	}
}
