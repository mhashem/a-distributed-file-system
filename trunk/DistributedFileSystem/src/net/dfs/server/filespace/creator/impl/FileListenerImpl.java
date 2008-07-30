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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import net.dfs.server.filemodel.FileToken;
import net.dfs.server.filespace.creator.FileListener;
import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.event.RemoteEvent;
import net.jini.core.event.UnknownEventException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class FileListenerImpl implements FileListener{

private FileSpaceCreator spaceCreator;
private JavaSpace space ;
	
/**
 * 
 */
private static final long serialVersionUID = 1L;
	

public FileListenerImpl(){
	System.out.println("FILE LISTENER CALLED !!!");
			try {
				space = spaceCreator.getSpace(InetAddress.getLocalHost(), InetAddress.getLocalHost());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
}



public void notify(RemoteEvent event) throws UnknownEventException,RemoteException {

	try{
			FileToken temp = new FileToken();
			
			FileToken result = (FileToken) space.read(temp, null, Long.MAX_VALUE);
			System.out.println("NOTIFIED " +result.fileName);
			
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

	public void setSpaceCreator(FileSpaceCreator spaceCreator) {
		this.spaceCreator = spaceCreator;
	}
	
}
