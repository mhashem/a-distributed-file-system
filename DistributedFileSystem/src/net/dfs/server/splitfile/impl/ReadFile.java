/**
 * 
 */
package net.dfs.server.splitfile.impl;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dfs.server.splitfile.SplitFile;

/**
 * @author Rukshan
 *
 */
public class ReadFile {
	
	public static void main(String args []){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\spring-server.xml");
		SplitFile splitfile = (SplitFile) context.getBean("splitfile");
		
	//	((SplitFileImpl) splitfile).setFileName("C:\\Done.txt");
		//.setFile(new File("C:\\Done.txt"));
		splitfile.split();
		
	}
}
