package net.dfs.user.connect.impl;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.user.connect.RetrievalConnectionHandler;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RetrievalConnectionHandlerImpl implements RetrievalConnectionHandler{

	private static FileLocationTracker hashMap;
	
	public RetrievalManager createProxy() {

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://192.168.2.2:8989/RetrievalManager");
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		System.out.println("Connected !!!");
		return (RetrievalManager) proxyFactory.getObject();
	}

	public static void main(String args[]){
		RetrievalConnectionHandler retreive = new RetrievalConnectionHandlerImpl();
		RetrievalManager retrievalManager = (RetrievalManager) retreive.createProxy();
		retrievalManager.retrieveFile(hashMap.getValues("D:\\Working\\Done"));
		
	}
	
	public void retrieveFile() {
		
	}

	public static void setHashMap(FileLocationTracker hashMap) {
		RetrievalConnectionHandlerImpl.hashMap = hashMap;
	}

	
}
