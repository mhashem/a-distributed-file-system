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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import net.dfs.ui.UserUI;
import net.dfs.user.connect.StorageConnectionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static long FILE_SIZE = 0;
	private static Log log = LogFactory.getLog(Store.class);
	static ApplicationContext context;
	private static Properties props = new Properties();
	
	static{
		try {
			props.load(new FileInputStream("server.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Store application will be started with the main() of the {@link Store}.
	 * 
	 * @param args the parameter which is passed to the main()
	 * @throws IOException
	 */

	public static void userStarter()throws IOException{

		Store.context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		log.debug("The User "+InetAddress.getLocalHost().getHostAddress()+" Started");
	}
	
	public static void store(String file) throws UnknownHostException{
		File f = new File(file);
		FILE_SIZE = f.length();
		
		fileNameAnalyzer(file);

		
		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");
		String serverName = storageHandler.storeFile(FILE_SIZE, fileName, extention, InetAddress.getLocalHost().getHostAddress());

		Store.serverName(serverName);
		log.debug("The File "+fileName+extention+" With "+FILE_SIZE+" size send to the Server");
		
	}
	
	public static String userIP() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	public static String userName() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostName();
	}
	
	public static String serverIP(){
		return props.getProperty("server.ip");
	}

	public static void serverName(String name){
		UserUI.setServerName(name);
	}

	private static void fileNameAnalyzer(String file){

		String [] parts  = file.split("\\\\");
		String name = parts[parts.length-1];
		
		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				Store.fileName = name.substring(0,i);
				Store.extention = name.substring(i);
			}
		}
	}

 }
