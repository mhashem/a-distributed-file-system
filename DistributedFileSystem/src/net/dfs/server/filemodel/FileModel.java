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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import net.jini.core.entry.Entry;

/**
 * @author Rukshan Silva
 */
public class FileModel implements Entry{
	
	private static final long serialVersionUID = 1L;
	
	BufferedInputStream bufferedInputStream;
	BufferedOutputStream bufferedOutputStream;
	String fileName;
	int bytesRead;
	byte [] bytes;
		
	public InputStream getFis() {
		return bufferedInputStream;
	}
	
	public void setBufferedInputStream(String fileName) {
		try {
			this.bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public OutputStream getBufferedOutputStream() {
		return bufferedOutputStream;
	}

	public void setBufferedOutputStream(String fileName) {
		try {
			this.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return fileName;
	}
	public void setName(String name) {
		this.fileName = name;
	}
 
	public int getBytesRead() {
		return bytesRead;
	}
	
	public void setBytesRead(int bytesRead) {
		this.bytesRead = bytesRead;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}	
}
