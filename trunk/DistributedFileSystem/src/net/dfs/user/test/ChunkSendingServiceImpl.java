package net.dfs.user.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.dfs.server.filemodel.FileStorageModel;

public class ChunkSendingServiceImpl implements ChunkSendingService{
	private int bytesRead;
	
	private Map<String, BufferedInputStream> countMap = new HashMap<String, BufferedInputStream> ();
	
	public FileStorageModel sendChunk(String fileName, String ext, Integer CHUNK_SIZE) throws FileNotFoundException, IOException{
		
		BufferedInputStream inputStream ;
		String file = fileNameAnalyzer(fileName); 

		if (! countMap.containsKey(file)) {
			
			
			System.out.println("FILE "+file+" DOES NOT CONTAINS IN THE MAP");

			Properties prop = new Properties();
			prop.load(new FileInputStream("server.properties"));
	
			File f = new File(prop.getProperty("store.fileName"));
			inputStream = new BufferedInputStream(new FileInputStream(f));
			
			System.out.println("INPUT STREAM created");
			
			countMap.put(file, inputStream);
		}
		
		inputStream = countMap.get(file);
		System.out.println("FILE "+file+" CONTAINS IN THE MAP");
		
		byte [] buffer = new byte [CHUNK_SIZE];
		FileStorageModel fileModel = new FileStorageModel();

		bytesRead = inputStream.read(buffer);

		fileModel.fileName = fileName+ext;
		fileModel.bytes = buffer;
		fileModel.bytesRead = bytesRead;

//		countMap.put(file, inputStream);

		return fileModel;
		// FIXME You have to remove inputstream from map
	}
	
	private String fileNameAnalyzer(String file){

		String [] parts  = file.split("_");
		return parts[1];
	}	
	
}
