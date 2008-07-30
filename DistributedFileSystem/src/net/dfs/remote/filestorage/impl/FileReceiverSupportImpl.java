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

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import net.dfs.remote.filestorage.FileReceiverSupport;
import net.dfs.remote.filestorage.StorageManager;
import net.dfs.server.chunkreceiver.TokenFileManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filemodel.FileToken;
import net.dfs.server.filespace.creator.FileSpaceCreator;
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
	private TokenFileManager tokenFileManager;;
	private String serverIP;
	private JavaSpace space;
	private StorageManager storageManager;
	private FileLocationTracker hashMap;
	private Log log = LogFactory.getLog(FileReceiverSupportImpl.class);
	
	/**
	 * connectJavaSpace will connect to the remote Space and get an instance of the Space. 
	 * Throws a RemoteException on a failure.
	 */
	public void connectJavaSpace(){
		
		try {
			log.debug("Space requested from "+ serverIP);
			if(space ==null){
				space = spaceCreator.getSpace(InetAddress.getByName(serverIP), InetAddress.getLocalHost());
			}	
			log.debug("Space Returned to "+ serverIP);

		} catch (UnknownHostException e) {
			log.debug("UnknownHostException @ FileReceiver Support");
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
		FileToken tempToken = new FileToken();
		
		if(space != null){
			
			for(;;){
				try {
					FileToken received = (FileToken) space.take(tempToken, null, Long.MAX_VALUE);
					log.info("Chunk "+received.fileName+" with Chunk No "+received.CHUNK_NO+" Taken from the Space");
					
					FileStorageModel fileStorageModel = tokenFileManager.receiveChunk(received.fileName, received.ext, received.CHUNK_NO);
					log.info("ACTUAL File "+fileStorageModel.fileName+" with bytes "+fileStorageModel.bytesRead+" bytes from the Space");
					
					storageManager.fileStorage(fileStorageModel);
					
					hashMap.createHashIndex(fileStorageModel.fileName, InetAddress.getLocalHost());
					
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (UnusableEntryException e) {
					e.printStackTrace();
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
//				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
			connectJavaSpace();
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
	
		
	public void setTokenFileManager(TokenFileManager tokenFileManager) {
		this.tokenFileManager = tokenFileManager;
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

	/**
	 * setHashMap will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileLocationTracker}
	 * 
	 * @param hashMap is an object of type {@link FileLocationTracker}
	 */
	public void setHashMap(FileLocationTracker hashMap) {
		this.hashMap = hashMap;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	
	
 }
