package net.dfs.server.retrieve.impl;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.retrieve.FileRetrievalService;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Implementation of the {@link FileRetrievalService} which is responsible in 
 * establishing connection with the remote node and request for the File 
 * object. 
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class FileRetrievalServiceImpl implements FileRetrievalService{

	private FileLocationTracker hashMap ;
//	private RetrievalConnectionHandler retreive;

	/**
	 * {@inheritDoc}
	 */
	public RetrievalManager createProxy() {
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://192.168.2.2:8989/RetrievalManager");
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		System.out.println("Connected !!!");
		return (RetrievalManager) proxyFactory.getObject();
	}

	/**
	 * {@inheritDoc}
	 */
	public void retrieveFile(String fileName) {
		RetrievalManager retrievalManager = (RetrievalManager) createProxy();
		
		System.out.println("Done !!!");
		retrievalManager.retrieveFile("D:\\Working\\Done_10.txt");
		//hashMap.getValues(fileName)
	}
	
	/**
	 * setHashMap will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileLocationTracker}
	 * 
	 * @param hashMap is an object of type {@link FileLocationTracker}
	 */
	public void setHashMap(FileLocationTracker hashMap) {
		this.hashMap = hashMap;
	}

 }
