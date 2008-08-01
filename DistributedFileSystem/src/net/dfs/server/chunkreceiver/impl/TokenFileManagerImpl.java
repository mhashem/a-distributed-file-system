package net.dfs.server.chunkreceiver.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.dfs.server.chunkreceiver.TokenFileManager;
import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.user.test.ChunkSendingService;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;



public class TokenFileManagerImpl implements TokenFileManager{
	
	private UserRegistrationService userRegistration;
	private Integer CHUNK_SIZE;
	
	
	public ChunkSendingService createProxy(String fileName) {
		
		String userIP = userRegistration.invokeUser(fileNameAnalyzer(fileName));
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+userIP+":8989/ChunkSendingService");
		proxyFactory.setServiceInterface(ChunkSendingService.class);
		proxyFactory.afterPropertiesSet();
		ChunkSendingService s = (ChunkSendingService) proxyFactory.getObject();

		return s;
	}
	
	public FileStorageModel receiveChunk(String fileName, String ext, Integer CHUNK_NO) throws FileNotFoundException, IOException {
		
		ChunkSendingService chunkSendingService	= (ChunkSendingService)createProxy(fileName);	
		FileStorageModel fileModel = chunkSendingService.sendChunk(fileName,ext,CHUNK_SIZE);

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
