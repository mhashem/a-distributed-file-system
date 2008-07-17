package net.dfs.server.retrievefile.impl;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.HashModel;
import net.dfs.server.filespace.accessor.ReadSpaceAccessor;
import net.dfs.server.retrievefile.FileRetrievalService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private ReadSpaceAccessor readSpace;
	private Log log = LogFactory.getLog(FileRetrievalServiceImpl.class);
	private String serverIP;
	
	/**
	 * {@inheritDoc}
	 */
	public RetrievalManager createProxy(String client) {
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+serverIP+":8989/RetrievalManager."+client);
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		return (RetrievalManager) proxyFactory.getObject();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void retrieveFile(final String fileName) {

		new Thread(new Runnable() {

			public void run() {
				hashMap.retrieveKeys();
				HashModel [] fileNames = hashMap.getValues(fileName);

				for (HashModel file : fileNames) {

					RetrievalManager retrievalManager = (RetrievalManager) createProxy(file.getValue());
					retrievalManager.retrieveFile(file.getKey());
					log.debug("Get the File "+file.getKey()+" from the Client "+file.getValue());
				}
				readSpace.fileSpace();
				readSpace.readFromSpace();
			}
			
		}).start();
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

	/**
	 * setReadSpace will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link ReadSpaceAccessor}
	 * 
	 * @param readSpace is an object of type {@link ReadSpaceAccessor}
	 */
	public void setReadSpace(ReadSpaceAccessor readSpace) {
		this.readSpace = readSpace;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

 }
