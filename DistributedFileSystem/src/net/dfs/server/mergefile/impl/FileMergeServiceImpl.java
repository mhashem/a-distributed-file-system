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

package net.dfs.server.mergefile.impl;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.mergefile.FileMergeService;

/**
 * Implementation of the {@link FileMergeService}, and will merge all the 
 * File objects which have been written to the Space by the remote nodes.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
public class FileMergeServiceImpl implements FileMergeService{
	private static byte temp[] = new byte [1024];
	
	/**
	 * {@inheritDoc}ss
	 */
	public void merge(FileRetrievalModel file) {

		temp = concatenate(temp, file.bytes,file.bytesRead);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveFile(){
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\Done.txt"));
			out.write(temp);
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * concatenate will merge the temporary array with the newly taken 
	 * File object from the Space. And make all the File objects merged together 
	 * and make a one File.
	 * 
	 * @param a the <i>temp</i> array.
	 * @param b the bytes in the File object.
	 * @param bytesRead the total bytes read in the File object.
	 * @return the merged single byte stream of File.
	 */
    protected static byte[] concatenate(byte[] a, byte[] b, int bytesRead) {
    	byte[] r = new byte[a.length + b.length];
    	System.arraycopy(a, 0, r, 0, a.length);
    	System.arraycopy(b, 0, r, a.length, bytesRead);
    	return r;
    }
}
