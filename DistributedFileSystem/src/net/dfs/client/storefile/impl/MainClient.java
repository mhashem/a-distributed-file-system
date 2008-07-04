package net.dfs.client.storefile.impl;

import net.dfs.client.storefile.StoreFile;
import net.dfs.server.filespace.impl.FileSpaceImpl;
import net.dfs.server.splitfile.SplitFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClient {

	private static StoreFile storeFile;
	private static Log log = LogFactory.getLog(FileSpaceImpl.class);
	
	public static void main(String args []) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\server\\filespace\\spring-server.xml");
//		StoreFile storeFile = (StoreFile) context.getBean("storeFile");
		
		MessageShell ms = (MessageShell) context.getBean("ms");
		ms.readImpl();
		log.debug("-- Calling connectJavaSpace()");
		storeFile.storeFile();
	}

	public static void setStoreFile(StoreFile storeFile) {
		MainClient.storeFile = storeFile;
	}

}

