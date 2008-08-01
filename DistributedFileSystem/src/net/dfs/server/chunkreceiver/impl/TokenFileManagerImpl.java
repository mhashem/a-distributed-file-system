package net.dfs.server.chunkreceiver.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.dfs.server.chunkreceiver.TokenFileManager;
import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.user.test.ChunkSendingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;



public class TokenFileManagerImpl implements TokenFileManager{
	
	private UserRegistrationService userRegistration;
	private Integer CHUNK_SIZE;
	private Log log = LogFactory.getLog(TokenFileManagerImpl.class);

	
	public ChunkSendingService createProxy(String fileName, String userIP) {
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+userIP+":8989/ChunkSendingService");
		proxyFactory.setServiceInterface(ChunkSendingService.class);
		proxyFactory.afterPropertiesSet();
		ChunkSendingService serivce = (ChunkSendingService) proxyFactory.getObject();

		return serivce;
	}
	
	public FileStorageModel receiveChunk(final String fileName, final String ext, final Integer CHUNK_NO) throws FileNotFoundException, IOException {
			
		String userIP = userRegistration.invokeUser(fileNameAnalyzer(fileName));

		ChunkSendingService chunkSendingService	= (ChunkSendingService)createProxy(fileName, userIP);	
		FileStorageModel fileModel = chunkSendingService.sendChunk(fileName,ext,CHUNK_SIZE);

		log.debug("File "+fileName+" Recieved from "+userIP);
		return fileModel;
}

	private String fileNameAnalyzer(String file){

		String [] parts  = file.split("_");
		return parts[1];
	}	
	
	public void setCHUNK_SIZE(Integer chunk_size) {
		CHUNK_SIZE = chunk_size;
	}

	public void setUserRegistration(UserRegistrationService userRegistration) {
		this.userRegistration = userRegistration;
	}

}
