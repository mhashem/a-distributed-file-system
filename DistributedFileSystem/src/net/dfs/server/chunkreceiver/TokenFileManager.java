package net.dfs.server.chunkreceiver;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.dfs.server.filemodel.FileStorageModel;

public interface TokenFileManager {
	
	public FileStorageModel receiveChunk(String fileName, String ext, Integer CHUNK_NO) throws FileNotFoundException, IOException;
	
}
