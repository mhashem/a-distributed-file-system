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

package net.dfs.server.token.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.filemodel.FileToken;
import net.dfs.server.filespace.accessor.WriteSpaceAccessor;
import net.dfs.server.token.TokenService;

/**
 * Implementation of the {@link TokenService} which will Split the file into 
 * many per-defined sized chunks. Then set the properties of the File object 
 * model and send the wrapped File object to the Space.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class TokenServiceImpl implements TokenService {
	
	private WriteSpaceAccessor writeSpace;
	private String CHUNK_SIZE;
	private Integer NO_OF_CHUNKS;
	
//	private Log log = LogFactory.getLog(FileSplitServiceImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void createToken(long FILE_SIZE, String fileName, String ext) {
		
		
		NO_OF_CHUNKS = (int)FILE_SIZE / Integer.parseInt(CHUNK_SIZE);

		if(FILE_SIZE / Integer.parseInt(CHUNK_SIZE) != 0){
			NO_OF_CHUNKS += 1;
		}
		System.out.println("TOTAL CHUNKS = " + NO_OF_CHUNKS);
		
		for(int increment=1;increment<= NO_OF_CHUNKS;increment++){
			FileToken token = new FileToken();
			token.fileName = fileName+"_"+increment;
			token.ext = ext;
			token.CHUNK_NO = new Integer(increment);
			
			writeSpace.writeToSpace(token);
		}
		
/*		BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileStream));
		
		byte [] buffer = new byte [Integer.parseInt(CHUNK_SIZE)];
		Integer bytesRead = 0, increment = 0;
		FileStorageModel fileModel = new FileStorageModel();

		try {
			writeSpace.fileSpace();
			
			while((bytesRead = inputStream.read(buffer)) != -1){
				increment += 1;
				fileModel.fileName = fileName+"_"+increment+ext;
				fileModel.bytesRead = bytesRead;
				fileModel.bytes = buffer;
				
				writeSpace.writeToSpace(fileModel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
	}

	/**
	 * setWriteSpace will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link WriteSpaceAccessor}
	 * 
	 * @param writeSpace is an object of type {@link WriteSpaceAccessor}
	 */
	public void setWriteSpace(WriteSpaceAccessor writeSpace) {
		this.writeSpace = writeSpace;
	}

	public void setCHUNK_SIZE(String chunk_size) {
		CHUNK_SIZE = chunk_size;
	}

}
