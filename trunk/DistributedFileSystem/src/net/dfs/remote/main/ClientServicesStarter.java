package net.dfs.remote.main;

import net.dfs.remote.filestorage.FileReceiver;
import net.dfs.remote.filestorage.impl.FileReceiverImplementation;
import net.dfs.server.filespace.accessor.impl.FileSpaceAccessorImplementation;
import net.dfs.server.filesplitter.FileSplitService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServicesStarter {

	private static FileReceiver receiveFile;
	private static Log log = LogFactory.getLog(FileSpaceAccessorImplementation.class);
	
	public static void main(String args []) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\remote\\filestorage\\spring-client.xml");
		FileReceiverImplementation receiveFile = (FileReceiverImplementation) context.getBean("receiveFile");
		
		receiveFile.connectJavaSpace();
		receiveFile.retrieveFile();
	}

	public static void setReceiveFile(FileReceiver receiveFile) {
		ClientServicesStarter.receiveFile = receiveFile;
	}


}

