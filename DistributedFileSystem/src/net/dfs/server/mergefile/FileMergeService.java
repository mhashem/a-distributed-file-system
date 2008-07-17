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

package net.dfs.server.mergefile;

import net.dfs.server.filemodel.FileRetrievalModel;

/**
 * FileMergeService is responsible for merge all the File objects which 
 * have been taken from the Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileMergeService {
	
	 /**
	  * merge will aggregate all the File objects which taken from the Space.
	  * 
	  * @param file an object of the type {@link FileRetrievalModel}.
	  */
	public void merge(FileRetrievalModel file);
	
	/**
	 * save in the local HaaD
	 */
	public void saveFile();

 } 
