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

import net.dfs.server.filesplitter.FileSplitService;

/**
 * StorageConnectionHandler will store the file in the distributed network.
 * This will re-direct the byte stream of the File object to the 
 * {@link FileSplitService}. 
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
public interface StorageConnectionHandler {

	/**
	 * storeFile will re-direct the byte stream of the file to the 
	 * {@link FileSplitService}.
	 * 
	 * @param fileStream the byte stream of the File object
	 */
	public void storeFile(byte fileStream[]);

}	
