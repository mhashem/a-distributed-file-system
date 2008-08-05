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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import net.dfs.user.connect.RetrievalConnectionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static Log log = LogFactory.getLog(Retrieve.class);
	static ApplicationContext context ;
	/**
	 * Retrieve application will be started with the main() of the {@link Retrieve}.
	 * 
	 * @param args the parameter which is passed to the main()
	 * @throws UnknownHostException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */

	public static void startUser() throws UnknownHostException{
		context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		log.debug("The User "+InetAddress.getLocalHost().getHostAddress()+" Started");
	}
	
	public static void retrieve(String file) throws UnknownHostException, IOException{
		
		fileNameAnalyzer(file);

		RetrievalConnectionHandler retrieve = (RetrievalConnectionHandler) context.getBean("retrieve");

		retrieve.retrieveFile(fileName, extention, InetAddress.getLocalHost().getHostAddress());
		log.debug("The File "+fileName+extention+" Request from the Server");
	}
	
	@SuppressWarnings("static-access")
	private static void fileNameAnalyzer(String name){

		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				Retrieve.fileName = name.substring(0,i);
				Retrieve.extention = name.substring(i);
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
