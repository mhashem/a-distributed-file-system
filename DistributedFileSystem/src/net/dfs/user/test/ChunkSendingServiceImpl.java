package net.dfs.user.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.filemodel.FileStorageModel;

public class ChunkSendingServiceImpl implements ChunkSendingService{
	private static Log log = LogFactory.getLog(ChunkSendingServiceImpl.class);
    private Map<String, BufferedInputStream> countMap = new HashMap<String, BufferedInputStream> ();
	private int bytesRead, TEMP = 0;
	private long FILE_LENGTH = 0;
        
    public FileStorageModel sendChunk(String fileName, String ext, Integer CHUNK_SIZE) throws FileNotFoundException, IOException{
                
	    BufferedInputStream inputStream ;
	    String file = fileNameAnalyzer(fileName); 
	
	    if (! countMap.containsKey(file)) {

	    	log.debug("FILE "+file+" DOES NOT CONTAIN IN THE MAP");
			Properties prop = new Properties();
			prop.load(new FileInputStream("server.properties"));
			File f = new File(prop.getProperty("store.fileName"));
			inputStream = new BufferedInputStream(new FileInputStream(f));
			
			FILE_LENGTH = f.length();
			countMap.put(file, inputStream);
		}
	                
		inputStream = countMap.get(file);
		                
		byte [] buffer = new byte [CHUNK_SIZE];
		FileStorageModel fileModel = new FileStorageModel();
		bytesRead = inputStream.read(buffer);
		
		fileModel.fileName = fileName+ext;
		fileModel.bytes = buffer;
		fileModel.bytesRead = bytesRead;
		
		if(FILE_LENGTH == (long)TEMP){
	    	log.debug("VALUES CLEARED FROM THE MAP");
			countMap.clear();
		}
		
    	log.debug("File "+file+" with "+bytesRead+" bytes send to the Server");
		return fileModel;
        // FIXME You have to remove inputstream from map
}
        
    private String fileNameAnalyzer(String file){

		String [] parts  = file.split("_");
		return parts[1];
	}       
        
}
