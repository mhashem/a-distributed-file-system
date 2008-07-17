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
import java.util.Properties;
import java.util.zip.ZipInputStream;

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
	private static String fileName;
	private static String extention;

	
	/**
	 * Store application will be started with the main() of the {@link Store}.
	 * 
	 * @param args the parameter which is passed to the main()
	 * @throws IOException
	 */
	public static void main(String args[])throws IOException{
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("server.properties"));
		
		File f = new File(prop.getProperty("store.fileName"));
		ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(f)));
		System.out.println("ZIPPED !!!");
		
		
		List<Byte> bytes = new ArrayList<Byte>();
		int b = -1;
		
		while ((b = in.read()) != -1) {
			bytes.add((byte) b);
		}
		
		byte[] filebytes = new byte[bytes.size()];
		
		for(int i=0; i< bytes.size(); i++) {
			filebytes[i] = bytes.get(i);
		}
		
		Store store = new Store();
		store.fileNameAnalyzer(prop.getProperty("store.fileName"));

		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");

		storageHandler.storeFile(filebytes, fileName, extention);
	}
	
	
	@SuppressWarnings("static-access")
	private void fileNameAnalyzer(String file){

		String [] parts  = file.split("\\\\");
		String name = parts[parts.length-1];
		
		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				this.fileName = name.substring(0,i);
				this.extention = name.substring(i);
			}
		}
	}

 }
