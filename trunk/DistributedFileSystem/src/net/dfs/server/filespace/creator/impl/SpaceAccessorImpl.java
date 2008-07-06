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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.filespace.creator.SecurityManager;
import net.dfs.server.filespace.creator.SpaceAccessor;
import net.dfs.server.filespace.creator.SpaceHost;
import net.jini.core.discovery.LookupLocator;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.space.JavaSpace;


public class SpaceAccessorImpl implements SpaceAccessor{
	private SecurityManager security;
	private Log log = LogFactory.getLog(SpaceAccessorImpl.class);

	@SuppressWarnings("unchecked")
	public JavaSpace getSpace(String host) {
		
		try {
			security.securityManager();

			
			LookupLocator lookup = new LookupLocator("jini://" + host);
			log.debug("-- SpaceAccessor using locater: "+lookup);
			ServiceRegistrar registrar = lookup.getRegistrar();

			Class[] types = new Class[]{JavaSpace.class};
			log.debug("-- Entries Created");

			JavaSpace space = (JavaSpace) registrar.lookup(new ServiceTemplate(null,types,null));
			log.debug("-- Space Created");
			
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

	public void setSecurity(SecurityManager security) {
		this.security = security;
	}
	
	
}
