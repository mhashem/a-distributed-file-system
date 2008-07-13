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

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;

/**
 * FileSenderSupport responsible for write the requested files back to the Space.
 * The remote node will first get connected to the space, and then will receive an instance of 
 * the Space. The File, which passed from the {@link RetrievalManager} will then be 
 * written to the Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public interface FileSenderSupport {
	 
	 /** 
	  * connectJavaSpace will communicate with the {@link FileSpaceCreator} and 
	  * will receive an instance of the Space. It accepts no arguments and returns no values.
	  */
	  public void connectJavaSpace();
	
	 /** 
	  *	sendFile writes an instance of a File object to the Space. The file is been wrapped by all 
	  * its properties in the {@link RetrievalManager}. The File is been sent by {@link RetrievalManager}. 
	  * It returns no values.
	  * 
	  * @param file is an object of type {@link FileRetrievalModel}. 
	  */
	  public void sendFile(FileRetrievalModel file);

 }
