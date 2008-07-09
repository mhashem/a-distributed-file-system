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

import net.dfs.server.filespace.creator.FileSpaceCreator;
import net.dfs.server.filespace.creator.SecurityManager;
import net.jini.core.discovery.LookupLocator;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.space.JavaSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FileSpaceCreatorImplementation implements FileSpaceCreator{
	private SecurityManager securityManager;
	private Log log = LogFactory.getLog(FileSpaceCreatorImplementation.class);

	@SuppressWarnings("unchecked")
	public JavaSpace getSpace(String host) {
		
		try {
			securityManager.securityManager();

			
			LookupLocator lookup = new LookupLocator("jini://" + host);
			log.debug("-- SpaceAccessor using locater: "+lookup);
			ServiceRegistrar registrar = lookup.getRegistrar();

			Class[] types = new Class[]{JavaSpace.class};

			JavaSpace space = (JavaSpace) registrar.lookup(new ServiceTemplate(null,types,null));
			log.debug("-- Accessed to the Space");
			
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

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

	
}
