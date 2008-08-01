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

package net.dfs.server.retrievefile;

import net.dfs.remote.fileretrieve.RetrievalManager;

/**
 * FileRetievalService is responsible in establishing connection with the 
 * remote node and request for the File object. 
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileRetrievalService {
	
	/**
	 * createProxy will establish the RMI connection between the server and the 
	 * remote node. The <i>stub</i> part of the connection will be 
	 * configured manually and the  <i>skeleton</i> part will be configured automatically 
	 * within the Spring container. 
	 * <p>
	 * The Server will simply get connected to the give remote node and sends a 
	 * message requesting for the given File object.
	 * 
	 * @return RetrievalManager is an object of the type {@link RetrievalManager}.
	 */
	public RetrievalManager createProxy(String client);

	/**
	 * retrieveFile get the RMI connection established by the createProxy.
	 * 
	 * @param fileName the Name of the File object.
	 */
	public void retrieveFile(String fileName, String ext);
 }
