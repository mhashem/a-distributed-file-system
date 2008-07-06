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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

import net.dfs.server.filespace.creator.SecurityManager;
import net.dfs.server.filespace.creator.SpaceAccessor;
import net.dfs.server.filespace.creator.SpaceHost;
import net.jini.core.entry.Entry;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class MessagePadImpl {

private static SpaceHost spaceHost;

	public static void main(String args[]) throws RemoteException{


			SpaceAccessor lookup = new SpaceAccessorImpl();
			
			JavaSpace space;
			
				space = lookup.getSpace(spaceHost.getHostAddress());
			
			if(space != null){
				//read input from console
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {	
				//create a message entry
				MessageImpl msg = new MessageImpl();
								
					while ((line = reader.readLine()).length() > 0) {
						// set the message text
						((MessageImpl) msg).text = line;
						// write a message per line entered
						space.write((Entry) msg, null, Long.MAX_VALUE);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				// we were unable to find the JavaSpaces service specified
				System.out.println("Unable to find ");
				System.exit(1);
			}

		}

	public static void setSpaceHost(SpaceHost spaceHost) {
		MessagePadImpl.spaceHost = spaceHost;
	}
	
}
