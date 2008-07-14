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

package net.dfs.remote.main;

import net.dfs.remote.filestorage.FileReceiverSupport;
import net.dfs.remote.filestorage.impl.FileReceiverSupportImpl;
import net.dfs.server.filespace.accessor.impl.FileSpaceAccessorImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClientServicesStarter is responsible in starting all the Client's services.
 * The Spring container will auto-wire the dependencies of all the Classes and
 * the client application will be started with the {@link FileReceiverSupport}
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class ClientServicesStarter {

	private static Log log = LogFactory.getLog(FileSpaceAccessorImpl.class);
	
	/**
	 * Client application will be started with the main() of the {@link ClientServicesStarter}
	 * 
	 * @param args the parameter which is passed to the main()
	 */
	public static void main(String args []) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\remote\\filestorage\\spring-client.xml");
		FileReceiverSupport receiveFile = (FileReceiverSupport) context.getBean("receiveFile");
		
		receiveFile.connectJavaSpace();
		receiveFile.retrieveFile();
		log.debug("-- Client Started");
	}
 }

