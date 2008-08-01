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

import java.io.IOException;
import java.net.InetAddress;

import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.jini.core.discovery.LookupLocator;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the {@link FileSpaceCreator} which creates the security 
 * policy and then will create and return the Space for the given host address.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class FileSpaceCreatorImpl implements FileSpaceCreator{
	private Log log = LogFactory.getLog(FileSpaceCreatorImpl.class);
	
	/**
	 * getSpace will simply creates a security manager. Establishes a RMI connection 
	 * which will be used in connection to the remote nodes. And finally, will create 
	 * a virtual Space and return an instance of it to the caller. An 
	 * IOException or a ClassNotFoundException will be thrown on a failure.
	 * 
	 * @param host the address of the node in which the Space needed to be created.
	 * @return the newly created Space.
	 */
	@SuppressWarnings("unchecked")
	public JavaSpace getSpace(InetAddress host, InetAddress requester) {
		
		try {
			log.info("Space Reqested by "+requester.getHostAddress());

			SecurityPolicyManager.securityManager();
			LookupLocator lookup = new LookupLocator("jini://localhost");
			ServiceRegistrar registrar = lookup.getRegistrar();

			Class[] types = new Class[]{JavaSpace.class};
			JavaSpace space = (JavaSpace) registrar.lookup(new ServiceTemplate(null,types,null));

			log.info("Space Returned to "+requester.getHostAddress());
			
			return space;
			
		} catch (IOException e) {
			e.printStackTrace();
    	    System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
    	    System.exit(1);
		}
		return null;
	}
	
}
