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

package net.dfs.server.filemodel;

import net.jini.entry.AbstractEntry;

/**
 * FileStorageModel is the File object model class which extends from AbstractEntry. 
 * The class contains all the properties which will be consists in a File object 
 * model. The model used in storing the files in the remote nodes.
 * <p>
 * The values are being setting at the constructor.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */ 
 public class FileStorageModel extends AbstractEntry{
	
	private static final long serialVersionUID = 1L;
	
	public String fileName;
	public int bytesRead;
	public byte [] bytes;

	/**
	 * The constructor which accepts no values.
	 */
	public FileStorageModel(){
		
	}
	
	/**
	 * The constructor which accepts the File Name and set it to the File's property, 
	 * fileName.
	 */
	public FileStorageModel(String fileName){
		super();
		this.fileName = fileName;
	}	

	/**
	 * The constructor which accepts the total bytes read in the File 
	 * and set it to the File's property, bytesRead.
	 */
	public FileStorageModel(Integer bytesRead){
		super();
		this.bytesRead =  bytesRead;
	}	
	
	/**
	 * The constructor which accepts the total bytes in the file and set it to the 
	 * File's property, bytes.
	 */
	public FileStorageModel(byte bytes[]){
		super();
		this.bytes = bytes;
	}	
 }
