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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * FileCreator will create a Stream of bites with the given File Object Name.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class FileCreator {
	
	 /**
	  * bufferdInputStreamCreator will create a BufferdInputStream with the given 
	  * byte Stream.
	  * 
	  * @param file the byte stream of the File object of {@link FileStorageModel} and
	  * {@link FileRetrievalModel}.
	  * @return the BufferdInputStream of the given byte stream.
	  */
	 public static BufferedInputStream BufferedInputStreamCreator(byte file []) {
		return (new BufferedInputStream(new ByteArrayInputStream(file)));
	 }
	 
	 /**
	  * bufferdOutputStreamCreator will create a BufferdOutputStream for the given 
	  * File Name.
	  * 
	  * @param fileName the Name of the File which is to be saved of the type {@link FileStorageModel}
	  * or {@link FileRetrievalModel}.
	  * @return the BufferdOutputStream of the given File Name.
	  */
	 public static BufferedOutputStream BufferedOutputStreamCreator(String fileName) {
		try {
			return (new BufferedOutputStream(new FileOutputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	 }
 }
