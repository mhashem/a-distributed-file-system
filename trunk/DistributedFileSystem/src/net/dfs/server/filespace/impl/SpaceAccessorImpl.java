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

package net.dfs.server.filespace.impl;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.SpaceAccessor;

public class SpaceAccessorImpl implements SpaceAccessor {
	
	public void space(){
		SecurityManager security =  new SecurityManagerImpl();
		security.securityManager();
		Lookup lookup = new LookupImpl();
		((LookupImpl) lookup).setHostname("localhost");
		lookup.getSpace();
	}
}
