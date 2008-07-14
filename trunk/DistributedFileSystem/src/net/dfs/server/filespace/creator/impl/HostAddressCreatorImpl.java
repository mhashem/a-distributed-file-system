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

import net.dfs.server.filespace.creator.HostAddressCreator;

/**
 * Implementation of the {@link HostAddressCreator} which will simply returns 
 * the address of the Server node.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class HostAddressCreatorImpl implements HostAddressCreator{
	
	/**
	 * {@inheritDoc}
	 */
	public String getHostAddress() {
		
		String host = null;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		return host;
	}

 }
