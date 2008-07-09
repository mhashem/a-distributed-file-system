/**
 * 
 */
package net.dfs.server.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import net.dfs.server.filesplitter.FileSplitService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerServicesStarter {
	private Log log = LogFactory.getLog(ServerServicesStarter.class);

	public static void main(String args []) throws FileNotFoundException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\creator\\spring-server.xml");
		FileSplitService splitfile = (FileSplitService) context.getBean("splitfile");
		
		splitfile.split(new FileInputStream("C:\\Done.txt"));
	}
}
