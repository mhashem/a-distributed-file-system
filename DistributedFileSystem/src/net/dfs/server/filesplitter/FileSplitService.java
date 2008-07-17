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

package net.dfs.server.filesplitter;


/**
 * FileSplitService will Split the file into many per-defined sized chunks. Then set the 
 * properties of the File object model and send the wrapped File object to the 
 * Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileSplitService {
	
	/**
	 * split will split the file into many per-defined sized chunks. Each chunk 
	 * will model to a File object and will set the properties of fileName, total 
	 * bytes in the File and total bytes actually reads in the File.
	 * <p>
	 * The modeled File object will be then sent to the Space for the distribution.
	 * It returns no value.
	 * 
	 * @param fileStream the byte stream of the file which is been sent by the user.
	 */
	public void split(byte fileStream[], String fileName, String ext);

 }
