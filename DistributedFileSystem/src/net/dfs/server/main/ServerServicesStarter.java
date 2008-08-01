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
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	/**
	 * main will load the Application Context which, in-turn will load the 
	 * Spring container with all the bean definitions. 
	 * 
	 * @param args the parameter which is passed to the main().
	 * @throws FileNotFoundException
	 */
	public static void main(String args []) throws FileNotFoundException{

		Properties props = new Properties();

		try {
			props.load(new FileInputStream("server.properties"));
			props.put("server.ip", InetAddress.getLocalHost().getHostAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\creator\\spring-server.xml");

		log.info("Server Started");
	}
	
	public void exitServer(){
		System.out.print("Server Terminated...");
		System.exit(1);
	}
 }
