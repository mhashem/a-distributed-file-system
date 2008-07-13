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

package net.dfs.server.filespace.accessor;

import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;

/**
 * FileSpaceAccessor will get connected to the Space and write the File objects to the 
 * Space. The Space is local to the Server and will receives an instance upon a successful 
 * creation of a Space at {@link FileSpaceCreator}.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileSpaceAccessor {
	
	/**
	 * fileSpace will connect to the {@link FileSpaceCreator} and get an instance of the Space. 
	 * Throws a RemoteException on a failure. It accepts no values and returns 
	 * no value.
	 */
	public void fileSpace();

	/**
	 * writeToSPace will write a File object to the newly created local Space.
	 * 
	 * @param file is an object of the type {@link FileStorageModel}
	 */
	public void writeToSpace(FileStorageModel file);

 }
