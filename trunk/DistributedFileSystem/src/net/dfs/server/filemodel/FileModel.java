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
 * @author Rukshan Silva
 */
public class FileModel extends AbstractEntry{
	
	private static final long serialVersionUID = 1L;
	
	public String fileName;
	public Integer bytesRead;
	public byte [] bytes;

	
	public FileModel(){
		
	}	

	public FileModel(String fileName){
		super();
		this.fileName = fileName;
		
	}	
	public FileModel(Integer bytesRead){
		super();
		this.bytesRead =  bytesRead;
	}	
	public FileModel(byte bytes[]){
		super();
		this.bytes = bytes;
	}	
}
