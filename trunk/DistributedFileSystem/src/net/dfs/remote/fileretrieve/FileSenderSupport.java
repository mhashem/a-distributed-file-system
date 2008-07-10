package net.dfs.remote.fileretrieve;

import net.dfs.server.filemodel.FileRetrievalModel;

public interface FileSenderSupport {
	
	public void connectJavaSpace();
	
	public void sendFile(FileRetrievalModel file);
}
