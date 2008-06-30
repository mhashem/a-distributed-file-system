/**
 * 
 */
package net.dfs.server.splitfile.impl;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dfs.server.filespace.impl.FileSpaceImpl;
import net.dfs.server.splitfile.SplitFile;

/**
 * @author Rukshan
 *
 */
public class ReadFile {
	private Log log = LogFactory.getLog(ReadFile.class);

	public static void main(String args []){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\spring-server.xml");
		SplitFile splitfile = (SplitFile) context.getBean("splitfile");
		
	//	((SplitFileImpl) splitfile).setFileName("C:\\Done.txt");
		//.setFile(new File("C:\\Done.txt"));
		splitfile.split();
		
		
	}
}
