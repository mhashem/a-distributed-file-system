package net.dfs.server.retrievefile.impl;

import java.io.IOException;

import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.filemodel.HashModel;
import net.dfs.server.noderegistration.RemoteNodeRegistration;
import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.server.retrievefile.FileRetrievalService;
import net.dfs.user.connect.sender.SendFileManager;

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
	private SendFileManager sendFileManager;
	private UserRegistrationService userRegistration;
	private RemoteNodeRegistration nodeRegistration;
	
	private Log log = LogFactory.getLog(FileRetrievalServiceImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	public RetrievalManager createProxy(String client) {
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+client+":8989/RetrievalManager."+client);
		proxyFactory.setServiceInterface(RetrievalManager.class);
		proxyFactory.afterPropertiesSet();
		return (RetrievalManager) proxyFactory.getObject();
	}
	
	/**
	 * {@inheritDoc}
	 * @return 
	 * @throws IOException 
	 */
	public void retrieveFile(final String fileName, final String ext){

		final String user = userRegistration.invokeUser(fileName);

		new Thread(new Runnable() {

			public void run() {
				hashMap.retrieveKeys();
				HashModel [] fileNames = hashMap.getValues(user+"_"+fileName,ext);

				for (HashModel file : fileNames) {

					try {
						if(nodeRegistration.isConnected(file.getValue())){

							RetrievalManager retrievalManager = (RetrievalManager) createProxy(file.getValue());
							FileRetrievalModel fileRetrievalModel = retrievalManager.retrieveFile(file.getKey());
	
							log.debug("Recieve the File "+file.getKey()+" from the Client "+file.getValue());
							sendFileManager.sendFile(fileRetrievalModel);
			
							hashMap.deleteHashIndex(fileNameAnalyzer(fileRetrievalModel.fileName));
						}
						else
							log.error("Cannot discover the Client "+file.getValue());
					} catch (IOException e) {
						log.error(e);
					}
				}
			}
			
		}).start();
	}
	
	private String fileNameAnalyzer(String file){

		String [] parts  = file.split("\\\\");
		return parts[parts.length-1];

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

	public void setSendFileManager(SendFileManager sendFileManager) {
		this.sendFileManager = sendFileManager;
	}

	public void setUserRegistration(UserRegistrationService userRegistration) {
		this.userRegistration = userRegistration;
	}

	public void setNodeRegistration(RemoteNodeRegistration nodeRegistration) {
		this.nodeRegistration = nodeRegistration;
	}
	
	
	
 }
