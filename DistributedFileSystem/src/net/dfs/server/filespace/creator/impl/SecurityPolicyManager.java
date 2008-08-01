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

import java.rmi.RMISecurityManager;

/**
 * Implementation of the {@link SecurityManager} and will grant permission in 
 * connecting with the remote nodes. It will allow Privileges in connecting 
 * to the Space
 * 
 * @version 1.0
 */
 public class SecurityPolicyManager{
	
	 /**
	  * {@inheritDoc}
	  */
	public static void securityManager() {
		try {
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new RMISecurityManager());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
 }
