package net.dfs.server.chunkreceiverimpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.dfs.server.chunkreceiver.TokenFileManager;
import net.dfs.server.filemodel.FileStorageModel;
import net.dfs.user.test.ChunkSendingService;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;



public class TokenFileManagerImpl implements TokenFileManager{
	private String userIP;
	private Integer CHUNK_SIZE;
	
	public ChunkSendingService createProxy() {
		
		RmiProxyFactoryBean proxyFactory = new RmiProxyFactoryBean();
		proxyFactory.setServiceUrl("rmi://"+userIP+":8989/ChunkSendingService");
		proxyFactory.setServiceInterface(ChunkSendingService.class);
		proxyFactory.afterPropertiesSet();
		return (ChunkSendingService) proxyFactory.getObject();
	}
	
	public FileStorageModel receiveChunk(String fileName, String ext, Integer CHUNK_NO) throws FileNotFoundException, IOException {
		
		ChunkSendingService chunkSendingService	= (ChunkSendingService)createProxy();	
		FileStorageModel fileModel = chunkSendingService.sendChunk(fileName,ext,CHUNK_SIZE);
			
		return fileModel;
	}

	public void setCHUNK_SIZE(Integer chunk_size) {
		CHUNK_SIZE = chunk_size;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

		
}
