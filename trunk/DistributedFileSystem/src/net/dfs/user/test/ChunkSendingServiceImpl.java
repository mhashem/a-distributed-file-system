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
	private Integer bytesRead,NO_OF_CHUNKS = 0;
	
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
		int b  = -1;
		List<Byte> bytes = new ArrayList<Byte>();
		
//		inputStream.skip(NO_OF_CHUNKS*CHUNK_SIZE);
		b = inputStream.read(buffer);
		bytes.add(b);
		
/*		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		
		List<Byte> bytes = new ArrayList<Byte>();
		int b = -1;
		
		while ((b = in.read()) != -1) {
			bytes.add((byte) b);
		}
		
		byte[] filebytes = new byte[bytes.size()];
		
		for(int i=0; i< bytes.size(); i++) {
			filebytes[i] = bytes.get(i);
		}
		
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		fileModel.fileName = fileName+ext;
		fileModel.bytes = buffer;
		fileModel.bytesRead = bytesRead;
		NO_OF_CHUNKS += 1;	

//		countMap.put(file, inputStream);

		return fileModel;
		// FIXME You have to remove inputstream from map
	}
	
	private String fileNameAnalyzer(String file){

		String [] parts  = file.split("_");
		return parts[1];
	}	
	
}
