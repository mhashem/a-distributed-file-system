package net.dfs.user.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.dfs.server.filemodel.FileStorageModel;

public interface ChunkSendingService {
	public FileStorageModel sendChunk(String fileName, String ext,Integer CHUNK_SIZE) throws FileNotFoundException, IOException;

}
