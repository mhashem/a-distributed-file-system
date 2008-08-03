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
import net.dfs.server.filespace.accessor.impl.WriteSpaceAccessorImpl;
import net.dfs.server.noderegistration.RemoteNodeRegistration;
import net.dfs.ui.NodeUI;

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
	 * Client application will be started with the main() of the {@link ClientServicesStarter}
	 * 
	 * @param args the parameter which is passed to the main()
	 */
	public static void startClient() {

		try {
			props.put("client.ip", InetAddress.getLocalHost().getHostAddress());

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		ClientServicesStarter client = new ClientServicesStarter();
		RemoteNodeRegistration nodeRegister = (RemoteNodeRegistration) client.startProxy();
		
		try {
			if(nodeRegister != null){
				String SERVER_IP = nodeRegister.registerNode(InetAddress.getLocalHost().getHostAddress());
				ClientServicesStarter.serverName(SERVER_IP);
				client.loadNode();
			}	
			else{
				log.debug("Server at "+props.getProperty("server.ip")+" not found");
				System.exit(1);
			}	
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
			
	}
	
	public RemoteNodeRegistration startProxy(){

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+props.getProperty("server.ip")+":8989/RemoteNodeRegistration");
		proxyFactory.setServiceInterface(RemoteNodeRegistration.class);
		proxyFactory.afterPropertiesSet();
	
		return (RemoteNodeRegistration) proxyFactory.getObject();
	}
	
	public final void loadNode(){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setProperties(props);

		context.addBeanFactoryPostProcessor(configurer);
		context.setConfigLocation("net\\dfs\\remote\\filestorage\\spring-client.xml");
		context.refresh();
		context.start();
		
/*		FileLocationTrackerImpl hash = new FileLocationTrackerImpl();
		hash.removeAll();
*/		
		log.info("Client Started");
		
		FileReceiverSupport receiveFile = (FileReceiverSupport) context.getBean("receiveFile");
		
		receiveFile.connectJavaSpace();
		receiveFile.retrieveFile();
	}
	
	public static String setLocation(String loc){
		props.put("remote.savepath", fileNameAnalyzer(loc));
		log.debug("Location "+props.getProperty("remote.savepath")+" Saved");
		return (loc);
	}
	
	public static String serverIP(){
		return props.getProperty("server.ip");
	}

	public static void serverName(String ip){
		NodeUI.setServerName(ip);
	}
	
	public static String clientIP() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}

	public static String clientName() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostName();
	}

	private static String fileNameAnalyzer(String file){
		String location = "";
		String [] parts  = file.split("\\\\");

		for(int i=0;i<parts.length;i++){
			location = location + (parts[i] + "\\\\");
		}
		return location;
	}

}

