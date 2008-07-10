/**
 * 
 */
package net.dfs.server.main;

import java.io.FileNotFoundException;

import net.dfs.user.connect.StorageConnectionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerServicesStarter {
	private Log log = LogFactory.getLog(ServerServicesStarter.class);
	

	public static void main(String args []) throws FileNotFoundException{
		String FileName = "C:\\Done.txt";
		byte b[] = FileName.getBytes();

		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\creator\\spring-server.xml");
		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");
		
		storageHandler.StoreFile(b);

	}
}
