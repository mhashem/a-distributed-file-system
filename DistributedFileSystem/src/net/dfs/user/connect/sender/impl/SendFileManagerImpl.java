package net.dfs.user.connect.sender.impl;

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.user.connect.sender.SendFileManager;
import net.dfs.user.test.LocalSave;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class SendFileManagerImpl implements SendFileManager{
	private Log log = LogFactory.getLog(SendFileManagerImpl.class);
	private UserRegistrationService userRegistration;
	/**
	 * {@inheritDoc}
	 */
	public LocalSave createProxy(String user) {

		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+user+":8989/LocalSave");
		proxyFactory.setServiceInterface(LocalSave.class);
		proxyFactory.afterPropertiesSet();
		return (LocalSave) proxyFactory.getObject();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void sendFile(final FileRetrievalModel received) {

		String user = userRegistration.invokeUser(fileNameAnalyzer(received.fileName));
				
		LocalSave save = (LocalSave) createProxy(user);
		save.saveFile(received);
		log.debug("The File "+received.fileName+" sent back to the User");
		
	}

	private String fileNameAnalyzer(String file){
		String extention = null;
		
		String [] parts_1  = file.split("\\\\");
		String name_1 = parts_1[parts_1.length-1];
		
		String [] parts_2  = name_1.split("_");
		String name_2 = parts_2[1];
		String name = parts_2[parts_2.length-1];
		
		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				extention = name.substring(i);
			}
		}
		return (name_2+extention);
	}

	public void setUserRegistration(UserRegistrationService userRegistration) {
		this.userRegistration = userRegistration;
	}

}
