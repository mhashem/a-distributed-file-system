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

package net.dfs.remote.filestorage.impl;

import java.rmi.RemoteException;

import net.dfs.remote.filestorage.FileReceiverSupport;
import net.dfs.remote.filestorage.StorageManager;
import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the {@link FileReceiverSupport}, which used in taking the 
 * File object from the remote Space. The connection to the Space is being first 
 * established with the remote Space. 
 * <p>
 * Then the File objects will be taken out from the 
 * Space and will provide the persistent storage via {@link StorageManager}.  
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class FileReceiverSupportImpl implements FileReceiverSupport{
	
	private FileSpaceCreator spaceCreator;
	private HostAddressCreator addressCreator;
	private JavaSpace space;
	private StorageManager storageManager;
	private Log log = LogFactory.getLog(FileReceiverSupportImpl.class);
	
	/**
	 * connectJavaSpace will connect to the remote Space and get an instance of the Space. 
	 * Throws a RemoteException on a failure.
	 */
	public void connectJavaSpace(){
		log.debug("-- ConnectJavaSpce()called ");
		
		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * retrieveFile will create an instance of {@link FileStorageModel} and takes
	 * the matching File objects from the Space. It makes sure that the Space is not
	 * null before taking the File objects.
	 * <p>
	 * The received File object will be then sent to the {@link StorageManager} for ensure
	 * the persistent storage. It accepts no values and returns no value.
	 */
	public void retrieveFile(){
		FileStorageModel fileTemp = new FileStorageModel();
		
		if(space != null){
			
			for(;;){
				try {
					FileStorageModel received = (FileStorageModel) space.take(fileTemp, null, Long.MAX_VALUE);
					log.debug("--" + received.fileName + " Bytes READ -- " + received.bytesRead);
					
					((StorageManagerImpl) storageManager).setStoreFile(received);
					storageManager.fileStorage();
					
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (UnusableEntryException e) {
					e.printStackTrace();
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else
			log.debug("-- Space is Null...");
	}

	/**
	 * setSpaceCreator will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileSpaceCreator}
	 * 
	 * @param spaceCreater is an object of type {@link FileSpaceCreator}
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
	
	/**
	 * setStorageManager will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link StorageManager}
	 * 
	 * @param storageManager is an object of type {@link StorageManager}
	 */
	public void setStorageManager(StorageManager storageManager) {
		this.storageManager = storageManager;
	}


 }
