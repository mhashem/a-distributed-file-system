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

package net.dfs.remote.filestorage;

import net.dfs.server.filespace.creator.FileSpaceCreator;


/**
 * FileRetrieverSupport connects to the Space and takes the File objects from the 
 * Space. This will retrieve an instance of the Space and then connect to the 
 * Space on the startup of the client. 
 * <p>
 * Client will be keep listening to the 
 * Space and when a File is been written to the Space, will take the File
 * from the Space and store the File via {@link StorageManager}  
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileReceiverSupport {
	
	 /** 
	  * connectJavaSpace will communicate with the {@link FileSpaceCreator} and 
	  * will receive an instance of the Space. It accepts no arguments and returns no values.
	  */
	public void connectJavaSpace();
	
	/**
	 * retrieveFile will get the File objects from the Space and send it to the 
	 * {@link StorageManager} for the Storage purposes.
	 */
	public void retrieveFile();
 }
