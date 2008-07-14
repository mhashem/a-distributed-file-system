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

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;

import net.dfs.remote.filestorage.StorageManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileStorageModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the {@link StorageManager} which provides persistent storage
 * in the local disk of the remote machine. After the File is been taken from the Space, 
 * a notification will be sent to the {@link FileLocationTracker}.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class StorageManagerImpl implements StorageManager{
	
	private FileStorageModel storeFile;
	private Log log = LogFactory.getLog(StorageManagerImpl.class);
	private FileLocationTracker hashMap ;
	private BufferedOutputStream outputStream;

	/**
	 * fileStorage will be responsible in storing the File object in the local
	 * storage device. A notification indicating the name of the File object and the 
	 * remote machine's address will be sent to the {@link FileLocationTracker}. 
	 * <p>
	 * An OutPutStream of the FileObject will be saved in the local storage device.
	 * IOException will be thrown on a failure. It accepts no values and returns 
	 * no value.
	 */
	public void fileStorage() {

		try {

			hashMap.createHashIndex(storeFile.fileName, InetAddress.getLocalHost().getHostAddress());
			
			outputStream = FileCreator.BufferedOutputStreamCreator(storeFile.fileName);

			outputStream.write(storeFile.bytes,0,storeFile.bytesRead);
			outputStream.flush();
			outputStream.close();
		
			log.debug("-- File " + storeFile.fileName + " Saved to the Disk");

		} catch (IOException e) {
			e.printStackTrace();
		}
//		hashMap.retrieveKeys();
	}
	
	/**
	 * setStoreFile will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileStorageModel}
	 * 
	 * @param storeFile is an object of type {@link FileStorageModel}
	 */
	public void setStoreFile(FileStorageModel storeFile) {
		this.storeFile = storeFile;
	}
	
	/**
	 * getStoreFile will return the stored File which is been set in the setStoreFile.
	 * it is been used as the local reference to the storeFile.
	 * 
	 * @return FileStorageModel is an object of type {@link FileStorageModel}
	 */
	public FileStorageModel getStoreFile() {
		return storeFile;
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

	
 }
