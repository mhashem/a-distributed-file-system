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

/**
 * Implementation of the {@link FileSenderSupport}, which used in connecting to the 
 * Space and send the File object to the Space. The dependent objects, which are
 * 	<ul>
 * 		<li>{@link FileSpaceCreator}</li>
 * 		<li>{@link HostAddressCreator} </li>
 * 	</ul>			
 *  will be injected automatically by Spring container.  
 * 
 * @author Rukshan Silva
 * @version 1.0
 * @see FileSpaceCreator
 */
 public class FileSenderSupportImpl implements FileSenderSupport{

	private FileSpaceCreator spaceCreator;
	private HostAddressCreator addressCreator;
	private JavaSpace space;
	private Log log = LogFactory.getLog(FileReceiverSupportImpl.class);
	
	/**
	 * connectJavaSpace will connect to the remote Space and get an instance of the Space. 
	 * Throws a RemoteException on a failure. It accepts no values and returns 
	 * no value.
	 */
	public void connectJavaSpace(){
		log.debug("-- ConnectJavaSpce()called AGAIN ");
		
		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sendFile will get an instance of the remote Space and write the file to the Space. 
	 * Make sure the returned Space is not null. only if the Space is not null, 
	 * the File object is being written to the Space. RemoteException or TransactionException
	 * will be thrown in a failure.It returns no value.
	 * {@inheritDoc} 
	 */
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
	
	/**
	 * setSpaceCreator will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileSpaceCreator}.
	 * returns no value.
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
