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

package net.dfs.user.connect.impl;

import net.dfs.server.filesplitter.FileSplitService;
import net.dfs.user.connect.StorageConnectionHandler;

/**
 * Implementation of the {@link StorageConnectionHandler}, provides the 
 * persistent storage in the distributed network.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class StorageConnectionHandlerImpl implements StorageConnectionHandler{
	private FileSplitService split;
	
	/**
	 * {@inheritDoc}
	 */
	public void storeFile(byte fileStream[], String fileName, String ext) {

		split.split(fileStream, fileName, ext);
	}

	/**
	 * setSplit will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileSplitService}
	 * 
	 * @param split is an object of type {@link FileSplitService}
	 */
	public void setSplit(FileSplitService split) {
		this.split = split;
	}
 }
