/**
 * 
 */
package net.dfs.server.main;

import java.io.FileNotFoundException;

import net.dfs.user.connect.StorageConnectionHandler;
import net.dfs.user.connect.impl.RetrievalConnectionHandlerImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerServicesStarter {
	private Log log = LogFactory.getLog(ServerServicesStarter.class);
	

	public static void main(String args []) throws FileNotFoundException{

		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\creator\\spring-server.xml");
		RetrievalConnectionHandlerImpl retreive = (RetrievalConnectionHandlerImpl) context.getBean("retreive");

	}
}
