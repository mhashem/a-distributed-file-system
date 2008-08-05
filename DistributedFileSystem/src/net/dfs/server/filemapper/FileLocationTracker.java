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

package net.dfs.server.filemapper;

import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filemodel.HashModel;
import net.dfs.server.filespace.accessor.WriteSpaceAccessor;

/**
 * FileLocationTracker is responsible in tracking which remote storage machine takes 
 * which File object. It simply keeps a track of all the Remote nodes which takes the 
 * File objects from the Space. 
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileLocationTracker {
	
	 
	 public void loadMap();
	 
	 /**
	  * createHashIndex will keep a track of all the File objects which is been 
	  * written to the SPace by the {@link WriteSpaceAccessor} with its corresponding 
	  * remote node which takes the File object from the Space.
	  * 
	  * @param key the Name of the File object, {@link FileStorageModel} which is been 
	  * written to the Space.
	  * @param value Address of the remote node which takes a single File Object from the 
	  * Space  
	  */
	public void createHashIndex(String key, String value);
	
	
	public void deleteHashIndex(String key);
	
	
	
	/**
	 * retrieveKeys will print all the associated pairs of keys and values.
	 */
	public void retrieveKeys();
	
	/**
	 * getValues will be return the value associated with the given key
	 * 
	 * @param key the Name of the File object.
	 * @return a list of String associating the remote nodes which contains the 
	 * given File object.
	 */
	public HashModel[] getValues(String key, String ext);
	
	/**
	 * removeValues will remove the associated key, value pairs which is 
	 * taken from the Space by the server.z
	 * 
	 * @param key
	 */
	public void removeAll();
	
	public void saveMap();
 } 
