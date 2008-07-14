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

import net.dfs.server.filemodel.FileRetrievalModel;

/**
 * ReadSpaceAccessor will get connected to the Space and read the File objects 
 * which have been written by the remote nodes.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface ReadSpaceAccessor {

	/**
	 * fileSpace will create an instance of the Space. It accepts no values 
	 * and return no value.
	 */
	public void fileSpace();
	
	/**
	 * readFromSpace will take all the File objects from the Space 
	 * which matches with {@link FileRetrievalModel}. It accepts no arguments 
	 * and return no argument. 
	 */
	public void readFromSpace();
 }
