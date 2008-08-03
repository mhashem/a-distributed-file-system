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

package net.dfs.server.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import net.dfs.server.filemapper.FileLocationTracker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ServerServicesStarter will load the Application Context in the main(). 
 * It simply loads the Spring container with all the bean definitions. 
 * Spring container will then inject all the dependencies. 
 * <p>
 * Therefore, the ServerServicesStarter will simply start the basic functionalities 
 * of the Server. 
 * 
 * @author Rukshan Silva
 * @version 1.0
 *
 */
 public class ServerServicesStarter {
	private static Log log = LogFactory.getLog(ServerServicesStarter.class);
	private static Properties props = new Properties();
	private static boolean flagServer = false;
	
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
	 * main will load the Application Context which, in-turn will load the 
	 * Spring container with all the bean definitions. 
	 * 
	 * @param args the parameter which is passed to the main().
	 * @throws IOException 
	 */
	//invoked by serverUI
	public static String startServer() throws IOException{

		String status = setServer(InetAddress.getLocalHost().getHostAddress());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\creator\\spring-server.xml");
		FileLocationTracker locationTrack = (FileLocationTracker) context.getBean("hashMap");
		locationTrack.loadMap();
		log.info("Server Started");
		
		//TODO UI
		//TODO Save/Load HashMap
		//TODO Commenting
		//TODO Threads
		//TODO HeartBeating
		//TODO Services Restart Scene

		locationTrack.saveMap();
		return status;
	}
	
	//invoked by serverUI
	public static String setServer(String server) throws FileNotFoundException, IOException{
		if(ServerServicesStarter.flagServer == false){
			props.put("server.ip", server);
			log.debug("Server "+server+" has been set");
			ServerServicesStarter.flagServer = true;
		}	
			return props.getProperty("server.ip");
	}
	
	//invoked by serverUI
	public static String serverName(){
		String name = null;
		try {
			name =  InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	//invoked by serverUI
	public static String setChunk(String chunk) throws FileNotFoundException, IOException{
			props.put("server.CHUNK_SIZE", chunk);
			log.debug("Chunk size "+chunk+" has been set");
			return props.getProperty("server.CHUNK_SIZE");
	}
	
	//invoked by serverUI
	public static String setSize(){
		return props.getProperty("server.CHUNK_SIZE");
	}
	
	//invoked by serverUI
	public static void exitServer(){
		log.debug("Server Terminated...");
		System.exit(1);
	}
 }
