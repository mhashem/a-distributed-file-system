package net.dfs.user.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.dfs.server.filemodel.FileStorageModel;

public class ChunkSendingServiceImpl implements ChunkSendingService{
	private static boolean flag = true;
	Integer bytesRead,i = 0;

	public FileStorageModel sendChunk(String fileName, String ext, Integer CHUNK_SIZE) throws FileNotFoundException, IOException{
	
		BufferedInputStream inputStream = null;
		byte [] buffer = new byte [CHUNK_SIZE];
		FileStorageModel fileModel = new FileStorageModel();
		
//		if (flag == true){
			Properties prop = new Properties();
			prop.load(new FileInputStream("server.properties"));
	
			File f = new File(prop.getProperty("store.fileName"));
			inputStream = new BufferedInputStream(new FileInputStream(f));
			
			System.out.println("INPUT STREAM created");
			flag = false;
//		}
		
		System.out.println("INPUT STREAM : "+ inputStream.available());

		inputStream.skip(i*CHUNK_SIZE);
		bytesRead = inputStream.read(buffer);

		System.out.println("BUFFER SIZE : "+ buffer.length);
			
		fileModel.fileName = fileName+ext;
		fileModel.bytes = buffer;
		fileModel.bytesRead = bytesRead;
		i += 1;	
		return fileModel;

	}
}
