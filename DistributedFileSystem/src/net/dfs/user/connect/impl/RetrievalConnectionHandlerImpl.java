package net.dfs.user.connect.impl;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.remote.filestorage.impl.FileReceiverSupportImpl;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.user.connect.RetrievalConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RetrievalConnectionHandlerImpl implements RetrievalConnectionHandler{

	private FileLocationTracker hashMap ;
//	private RetrievalConnectionHandler retreive;
	
	public RetrievalManager createProxy() {

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://192.168.2.2:8989/RetrievalManager");
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		System.out.println("Connected !!!");
		return (RetrievalManager) proxyFactory.getObject();
	}

	public static void main(String args[]){

		RetrievalConnectionHandlerImpl retriveFile = new RetrievalConnectionHandlerImpl();
		retriveFile.retrieveFile();
	
	}
	
	public void retrieveFile() {
		
//		RetrievalConnectionHandler retreive = new RetrievalConnectionHandlerImpl();
		RetrievalManager retrievalManager = (RetrievalManager) createProxy();
		
		System.out.println("Done !!!");
	//	hashMap.retrieveKeys();
		retrievalManager.retrieveFile(hashMap.getValues("D:\\Working\\Done"));
		
	}

	public void setHashMap(FileLocationTracker hashMap) {
		this.hashMap = hashMap;
	}


}
