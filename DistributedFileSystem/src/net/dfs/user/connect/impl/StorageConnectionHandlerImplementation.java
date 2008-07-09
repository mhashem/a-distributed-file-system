package net.dfs.user.connect.impl;

import java.io.FileInputStream;

import net.dfs.server.filesplitter.FileSplitService;
import net.dfs.server.filesplitter.impl.FileSplitServiceImplementation;
import net.dfs.user.connect.StorageConnectionHandler;

public class StorageConnectionHandlerImplementation implements StorageConnectionHandler{

	public void StoreFile(FileInputStream fileStream) {

		FileSplitService split = new FileSplitServiceImplementation();
		split.split(fileStream);
	}

}
