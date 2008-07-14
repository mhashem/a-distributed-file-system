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

package net.dfs.server.filespace.creator.impl;

import java.io.Serializable;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileStorageModel;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.event.RemoteEvent;
import net.jini.core.event.RemoteEventListener;
import net.jini.core.event.UnknownEventException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class FileListenerImpl implements RemoteEventListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JavaSpace space;
	
	public FileListenerImpl(JavaSpace space){
	
		System.out.println("FILE LISTENER CALLED !!!");
		this.space = space;
/*		try {
			UnicastRemoteObject.exportObject(this,0);
			System.out.println("UnicastRemoteObject DONE !!!");
		} catch (RemoteException e) {
			System.out.println("EXCEPTION !!!");
			e.printStackTrace();
		}
*/	}
	
	public void notify(RemoteEvent event) throws UnknownEventException,
			RemoteException {
		FileStorageModel temp = new FileStorageModel();
		
		try {
			FileStorageModel result = (FileStorageModel) space.read(temp, null, Long.MAX_VALUE);
		
			System.out.println(result.fileName);
		} catch (UnusableEntryException e) {
			System.out.println("EXCEPTION 1 !!!");
			e.printStackTrace();
		} catch (TransactionException e) {
			System.out.println("EXCEPTION 2 !!!");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("EXCEPTION 3 !!!");
			e.printStackTrace();
		}
		
		
	}

}
