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

import net.dfs.server.filemapper.FileLocationTracker;

/**
 * StorageManager will be responsible in storing the File physically in the local
 * storage. After the File is been taken from the Space, a notification will be sent 
 * to the {@link FileLocationTracker}.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface StorageManager {

	/**
	 * fileStorage will get the File object, which is been sent by {@link FileReceiverSupport} 
	 * and provide a persistent storage in the local disk.
	 */
	public void fileStorage();
	
 }
