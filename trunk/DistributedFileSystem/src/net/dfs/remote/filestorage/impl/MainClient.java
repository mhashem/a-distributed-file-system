package net.dfs.remote.filestorage.impl;

import net.dfs.remote.filestorage.FileReceiver;
import net.dfs.server.filespace.creator.impl.FileSpaceImpl;
import net.dfs.server.filesplitter.SplitFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClient {

	private static FileReceiver receiveFile;
	private static Log log = LogFactory.getLog(FileSpaceImpl.class);
	
	public static void main(String args []) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\remote\\filestorage\\spring-client.xml");
		FileReceiver receiveFile = (FileReceiver) context.getBean("receiveFile");
		
//		MessageShell ms = (MessageShell) context.getBean("ms");
//		ms.readImpl();
		
		receiveFile.connectJavaSpace();
		receiveFile.retrieveFile();
	}

	public static void setReceiveFile(FileReceiver receiveFile) {
		MainClient.receiveFile = receiveFile;
	}


}

