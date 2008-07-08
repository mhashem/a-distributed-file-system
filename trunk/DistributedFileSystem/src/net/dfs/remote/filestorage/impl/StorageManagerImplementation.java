package net.dfs.remote.filestorage.impl;

import java.io.IOException;
import java.net.InetAddress;

import net.dfs.remote.filestorage.StorageManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemapper.impl.FileLocationTrackerImplementation;
import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StorageManagerImplementation implements StorageManager{
	
	private FileModel storeFile;
	private Log log = LogFactory.getLog(StorageManagerImplementation.class);
	private FileLocationTracker hashTable ;

	public void fileStorage() {
	
		try {
			((FileLocationTracker) hashTable).setKey(storeFile.fileName);
			((FileLocationTracker) hashTable).setValue(InetAddress.getLocalHost().getHostAddress());
			hashTable.createHashIndex();
			
			FileCreator.setBufferedOutputStream(storeFile.fileName);
			FileCreator.getBufferedOutputStream().write(storeFile.bytes,0,storeFile.bytesRead);
			FileCreator.getBufferedOutputStream().flush();
			FileCreator.getBufferedOutputStream().close();
		
			log.debug("-- File " + storeFile.fileName + " Saved to the Disk");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setStoreFile(FileModel storeFile) {
		this.storeFile = storeFile;
	}

	public FileModel getStoreFile() {
		return storeFile;
	}

	public void setHashTable(FileLocationTracker hashTable) {
		this.hashTable = hashTable;
	}
	
}
