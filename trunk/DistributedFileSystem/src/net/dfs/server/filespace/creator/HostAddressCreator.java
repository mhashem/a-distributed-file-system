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

package net.dfs.server.filespace.creator;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * HostAddressCreater will get the Server's address and return to the caller 
 * object.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface HostAddressCreator extends Remote{
	
	 /**
	  * getHostAddtess will simply create the address of the local server and 
	  * returns the created address. 
	  * 
	  * @return the address of the Server.
	  * @throws RemoteException
	  */
	public String getHostAddress()throws RemoteException;
 }
