package net.dfs.remote.filestorage.impl;

import java.io.IOException;
import java.rmi.RemoteException;

import net.dfs.remote.filestorage.FileReceiver;
import net.dfs.remote.filestorage.StoreFile;
import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileReceiverImpl implements FileReceiver{
	
	private FileSpaceCreator spaceCreator;
	private HostAddressCreator addressCreator;
	private JavaSpace space;
	private StoreFile storeFile;
	private Log log = LogFactory.getLog(FileReceiverImpl.class);
	
	public void connectJavaSpace(){
		log.debug("-- ConnectJavaSpce()called ");
		
		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void retrieveFile(){
		FileModel fileTemp = new FileModel();
		
		if(space != null){
			
			for(;;){
				try {
					FileModel received = (FileModel) space.take(fileTemp, null, Long.MAX_VALUE);
					log.debug("--" + received.fileName + " Bytes READ -- " + received.bytesRead);
					
					((StoreFileImpl) storeFile).setStoreFile(received);
					storeFile.fileStorage();
					
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (UnusableEntryException e) {
					e.printStackTrace();
				} catch (TransactionException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else
			log.debug("-- Space is Null...");

	}


	public void setSpaceCreator(FileSpaceCreator spaceCreator) {
		this.spaceCreator = spaceCreator;
	}

	public void setAddressCreator(HostAddressCreator addressCreator) {
		this.addressCreator = addressCreator;
	}

	public void setStoreFile(StoreFile storeFile) {
		this.storeFile = storeFile;
	}
		

}
