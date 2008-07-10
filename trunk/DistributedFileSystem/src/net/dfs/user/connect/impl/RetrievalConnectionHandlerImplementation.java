package net.dfs.user.connect.impl;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.user.connect.RetrievalConnectionHandler;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RetrievalConnectionHandlerImplementation{

	public static RetrievalManager createProxy() {

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://192.168.2.2:8989/RetrievalManager");
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		System.out.println("Connected !!!");
		return (RetrievalManager) proxyFactory.getObject();
	}

	public static void main(String args[]){
		RetrievalManager retrievalManager = (RetrievalManager) RetrievalConnectionHandlerImplementation.createProxy();
		retrievalManager.retrieveFile("D:\\Working\\Done_1.txt");
	}

}
