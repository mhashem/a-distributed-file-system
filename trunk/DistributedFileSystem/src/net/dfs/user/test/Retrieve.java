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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.dfs.user.connect.RetrievalConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Retrieve will request for a File from the System
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
public class Retrieve {

	private static String fileName;
	private static String extention;

	/**
	 * Retrieve application will be started with the main() of the {@link Retrieve}.
	 * 
	 * @param args the parameter which is passed to the main()
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */

	public static void main(String args []) throws IOException{

		Properties prop = new Properties();
		prop.load(new FileInputStream("server.properties"));
		
		Retrieve ret = new Retrieve();
		ret.fileNameAnalyzer(prop.getProperty("retrieve.fileName"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		RetrievalConnectionHandler retrieve = (RetrievalConnectionHandler) context.getBean("retrieve");

		retrieve.retrieveFile(fileName, extention);
	}
	
	@SuppressWarnings("static-access")
	private void fileNameAnalyzer(String name){

		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				this.fileName = name.substring(0,i);
				this.extention = name.substring(i);
			}
		}
	}

	public static void setFileName(String fileName) {
		Retrieve.fileName = fileName;
	}

	public static void setExtention(String extention) {
		Retrieve.extention = extention;
	}
	
	
}
