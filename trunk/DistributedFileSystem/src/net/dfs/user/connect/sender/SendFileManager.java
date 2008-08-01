package net.dfs.user.connect.sender;

import net.dfs.server.filemodel.FileRetrievalModel;
import net.dfs.user.test.LocalSave;

public interface SendFileManager {
	
	public void sendFile(FileRetrievalModel received);
	
	public LocalSave createProxy(String user);
}
