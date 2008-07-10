package net.dfs.remote.filestorage.impl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;

import net.dfs.remote.filestorage.StorageManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileStorageModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StorageManagerImpl implements StorageManager{
	
	private FileStorageModel storeFile;
	private Log log = LogFactory.getLog(StorageManagerImpl.class);
	private FileLocationTracker hashMap ;
	private BufferedOutputStream outputStream;
	public void fileStorage() {

		try {

			hashMap.createHashIndex(storeFile.fileName, InetAddress.getLocalHost().getHostAddress());
			
			outputStream = FileCreator.BufferedOutputStreamCreator(storeFile.fileName);

			outputStream.write(storeFile.bytes,0,storeFile.bytesRead);
			outputStream.flush();
			outputStream.close();
		
			log.debug("-- File " + storeFile.fileName + " Saved to the Disk");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hashMap.retrieveKeys();
	}

	public void setStoreFile(FileStorageModel storeFile) {
		this.storeFile = storeFile;
	}

	public FileStorageModel getStoreFile() {
		return storeFile;
	}

	public void setHashMap(FileLocationTracker hashMap) {
		this.hashMap = hashMap;
	}

	
}
