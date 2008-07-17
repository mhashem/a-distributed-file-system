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

package net.dfs.user.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.dfs.user.connect.StorageConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Store will send the File to be sorted in the distributed network to Server 
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Store application will be started with the main() of the {@link Store}.
	 * 
	 * @param args the parameter which is passed to the main()
	 * @throws IOException
	 */
	public static void main(String args[])throws IOException{
		String fileName = "C:\\Done.txt";
		
		File f = new File(fileName);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		
		List<Byte> bytes = new ArrayList<Byte>();
		int b = -1;
		
		while ((b = in.read()) != -1) {
			bytes.add((byte) b);
		}
		
		byte[] filebytes = new byte[bytes.size()];
		
		for(int i=0; i< bytes.size(); i++) {
			filebytes[i] = bytes.get(i);
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");
	
		storageHandler.storeFile(filebytes);

		for(int i=0;i<fileName.length();i++){
			if(fileName.charAt(i) == '.'){
				System.out.println("FILE NAME :"+fileName.substring(0,i));
				System.out.println("Extention :"+fileName.substring(i+1));
			}
		}
	}
 }
