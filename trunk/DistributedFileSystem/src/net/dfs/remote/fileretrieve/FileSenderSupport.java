package net.dfs.remote.fileretrieve;

import net.dfs.server.filemodel.FileModel;

public interface FileSenderSupport {
	
	public void sendFile(FileModel file);
}
