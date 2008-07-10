package net.dfs.remote.fileretrieve.impl;

import java.rmi.RemoteException;

import net.dfs.remote.fileretrieve.FileSenderSupport;
import net.dfs.remote.filestorage.impl.FileReceiverSupportImpl;
import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FileSenderSupportImpl implements FileSenderSupport{

	private FileSpaceCreator spaceCreator;
	private HostAddressCreator addressCreator;
	private JavaSpace space;
	private Log log = LogFactory.getLog(FileReceiverSupportImpl.class);
	
	public void connectJavaSpace(){
		log.debug("-- ConnectJavaSpce()called AGAIN ");
		
		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void sendFile(FileRetrievalModel file) {

		if(space != null){

			try {
				space.write((FileRetrievalModel)file, null, Long.MAX_VALUE);
				log.debug("-- File " + file.fileName + " Written BACK to the Space");

			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}			
	}

	public void setSpaceCreator(FileSpaceCreator spaceCreator) {
		this.spaceCreator = spaceCreator;
	}

	public void setAddressCreator(HostAddressCreator addressCreator) {
		this.addressCreator = addressCreator;
	}
	
}
