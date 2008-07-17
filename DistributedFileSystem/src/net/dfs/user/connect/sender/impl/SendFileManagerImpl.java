package net.dfs.user.connect.sender.impl;

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.user.connect.sender.SendFileManager;
import net.dfs.user.test.LocalSave;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class SendFileManagerImpl implements SendFileManager{
	private Log log = LogFactory.getLog(SendFileManagerImpl.class);
	private String serverIP;

	/**
	 * {@inheritDoc}
	 */
	public LocalSave createProxy() {
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+serverIP+":8989/LocalSave");
		proxyFactory.setServiceInterface(LocalSave.class);
		proxyFactory.afterPropertiesSet();
		return (LocalSave) proxyFactory.getObject();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void sendFile(FileRetrievalModel received) {
		LocalSave save = (LocalSave) createProxy();
		save.saveFile(received);
		log.debug("The File "+received.fileName+" sent back to the User");
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}


	

}
