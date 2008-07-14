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

import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.filespace.accessor.ReadSpaceAccessor;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.HostAddressCreator;
import net.dfs.server.mergefile.FileMergeService;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the {@link ReadSpaceAccessor} will create a Space 
 * and take all the File objects of {@link FileRetrievalModel} which will 
 * be written by the remote nodes.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class ReadSpaceAccessorImpl implements ReadSpaceAccessor{

	private FileSpaceCreator spaceCreator;
	private JavaSpace space ;
	private HostAddressCreator addressCreator;
	private FileMergeService fileMerge;
	private Log log = LogFactory.getLog(ReadSpaceAccessorImpl.class);

	/**
	 * {@inheritDoc}
	 */
	public void fileSpace() {

		try {
			space = spaceCreator.getSpace(addressCreator.getHostAddress());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void readFromSpace() {

		if(space != null){
			FileRetrievalModel tempFile = new FileRetrievalModel();
			
			for(;;){
				try {
					FileRetrievalModel received = (FileRetrievalModel) space.take(tempFile, null, Long.MAX_VALUE);
					fileMerge.merge(received);
					
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
		fileMerge.saveFile();
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
	 * @param adressCreator is an object of type {@link HostAddressCreator}
	 */
	public void setAddressCreator(HostAddressCreator addressCreator) {
		this.addressCreator = addressCreator;
	}

	/**
	 * setFileMerge will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileMergeService}
	 * 
	 * @param fileMerge is an object of type {@link FileMergeService}
	 */
	public void setFileMerge(FileMergeService fileMerge) {
		this.fileMerge = fileMerge;
	}
	
 }
