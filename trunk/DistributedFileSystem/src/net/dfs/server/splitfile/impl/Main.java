/**
 * 
 */
package net.dfs.server.splitfile.impl;

import net.dfs.server.splitfile.SplitFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private Log log = LogFactory.getLog(Main.class);

	public static void main(String args []){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\spring-server.xml");
		SplitFile splitfile = (SplitFile) context.getBean("splitfile");
		
		splitfile.split();
		
	}
}
