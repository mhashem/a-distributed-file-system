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

package net.dfs.user.connect;

import net.dfs.server.retrievefile.FileRetrievalService;

/**
 * RetrievalConnectionHandler is the class given at the API to get connected with 
 * the User.It will re-direct the File Name to the {@link FileRetrievalService} 
 * which is been sent by the user.
 * 
 * @author Rukshan Silva
 *
 */
 public interface RetrievalConnectionHandler {

	 /**
	  * retrieveFile will re-direct the File Name to the {@link FileRetrievalService} 
	  * which is been sent by the user.
	  * 
	  * @param fileName the name of the File object.
	  */
	 public void retrieveFile(String fileName, String ext);
 }
