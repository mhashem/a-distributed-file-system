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

package net.dfs.remote.fileretrieve;

/**
 * RetrievalManager will get the File from the local storage, and the File objects'
 * properties are being set. Finally, send the file to the Space via {@link FileSenderSupport}.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface RetrievalManager {

	 /**
	  * retrieveFile will read the bytes in the saved File and wrap the newly created
	  * File with its name and bytes. Then the File will be sent to the {@link FileSenderSupport},
	  * which in-turn will be written to the Space. This returns no value.
	  * 
	  * @param fileNames is the collection of file names, which will be read from
	  * the local storage. 
	  */
	 public void retrieveFile(String fileNames);
 }
