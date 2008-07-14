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

import net.jini.space.JavaSpace;

/**
 * FileSpacCreator will set the security manager,  create the method invocation 
 * connections and creates an instance of the Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileSpaceCreator {

	/**
	 * getSpace will create an instance to the Space in the given host 
	 * and will return the created Space.
	 * 
	 * @param host the address of the node in which the Space needed to be created.
	 * @return the newly created Space.
	 */
	public JavaSpace getSpace(String host);

	
 }
