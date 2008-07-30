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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import net.dfs.remote.filestorage.FileReceiverSupport;
import net.dfs.server.filemapper.impl.FileLocationTrackerImpl;
import net.dfs.server.filespace.accessor.impl.WriteSpaceAccessorImpl;
import net.dfs.server.noderegistration.NodeRegistrationService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * ClientServicesStarter is responsible in starting all the Client's services.
 * The Spring container will auto-wire the dependencies of all the Classes and
 * the client application will be started with the {@link FileReceiverSupport}
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class ClientServicesStarter {

	private static Log log = LogFactory.getLog(WriteSpaceAccessorImpl.class);
	
	static Properties props = new Properties();

	/**
	 * Client application will be started with the main() of the {@link ClientServicesStarter}
	 * 
	 * @param args the parameter which is passed to the main()
	 */
	public static void main(String args []) {

		try {
			props.load(new FileInputStream("server.properties"));
			props.put("client.ip", InetAddress.getLocalHost().getHostAddress());
//			System.err.println("Server Client = " + props.get("server.client"));
			log.debug(props);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		ClientServicesStarter client = new ClientServicesStarter();
		NodeRegistrationService nodeRegister = (NodeRegistrationService) client.startProxy();
		
		try {
			if(nodeRegister != null){
				nodeRegister.registerNode(InetAddress.getLocalHost());
			}	
			else{
				log.debug("Server at "+props.getProperty("server.ip")+" not found");
				System.exit(1);
			}	
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
			
			client.loadNode();
	}
	
	public NodeRegistrationService startProxy(){

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+props.getProperty("server.ip")+":8989/NodeRegistrationService");
		proxyFactory.setServiceInterface(NodeRegistrationService.class);
		proxyFactory.afterPropertiesSet();
	
		return (NodeRegistrationService) proxyFactory.getObject();
	}
	
	public final void loadNode(){

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setProperties(props);

		context.addBeanFactoryPostProcessor(configurer);
		context.setConfigLocation("net\\dfs\\remote\\filestorage\\spring-client.xml");
		context.refresh();
		context.start();
		
		FileLocationTrackerImpl hash = new FileLocationTrackerImpl();
		hash.removeAll();
		
		log.info("Client Started");
		
		FileReceiverSupport receiveFile = (FileReceiverSupport) context.getBean("receiveFile");
		
		receiveFile.connectJavaSpace();
		receiveFile.retrieveFile();
	}

 }

