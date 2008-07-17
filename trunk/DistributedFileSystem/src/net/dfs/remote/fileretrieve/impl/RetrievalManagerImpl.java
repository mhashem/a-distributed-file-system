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

package net.dfs.remote.fileretrieve.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import net.dfs.remote.fileretrieve.FileSenderSupport;
import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.filespace.creator.FileSpaceCreator;

/**
 * Implementation of {@link RetrievalManager}, which used to read the File from the
 * remote storage machine's local storage. Then wrap the bites read into a File model
 * of type {@link FileRetrievalModel}. Then pass the File Object to the {@link FileSenderSupport}.
 *  
 * @author Rukshan Silva
 * @version 1.0
 */
 public class RetrievalManagerImpl implements RetrievalManager{

	private FileSenderSupport fileSender;
//	private Log log = LogFactory.getLog(RetrievalManagerImpl.class);

	/**
	 * Read the File from the local disk and send it to the Space.
	 * Connect to the remote Space via {@link FileSpaceCreator}. Read the bites in 
	 * the File into a InputStream and set the properties of the created File model. 
	 * <p>
	 * File model properties are FileName, the size of the file in bites and the
	 * actual bites read in the File. Finally send the wrapped File to the Space
	 * via {@link FileSenderSupport}
	 * <p>
	 * IOException will be thrown on a failure.
	 * {@inheritDoc}
	 */
	public void retrieveFile(String fileName) {
	
			try {
                
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                
                byte[] buffer = new byte [inputStream.available()];
				Integer bytesRead = 0;
				
				fileSender.connectJavaSpace();
				FileRetrievalModel fileModel = new FileRetrievalModel();
				
				while((bytesRead = inputStream.read(buffer)) != -1){
					fileModel.fileName = fileName;	
					fileModel.bytesRead = bytesRead;
					fileModel.bytes = buffer;
					
					fileSender.sendFile(fileModel);
				}
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	/**
	 * setFileSender will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileSenderSupport}
	 * 
	 * @param fileSender is an object of type {@link FileSenderSupport}
	 */
	public void setFileSender(FileSenderSupport fileSender) {
		this.fileSender = fileSender;
	}

 }
