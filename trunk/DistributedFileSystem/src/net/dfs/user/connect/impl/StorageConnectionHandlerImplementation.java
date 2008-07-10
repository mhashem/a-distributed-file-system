package net.dfs.user.connect.impl;

import java.io.FileInputStream;

import net.dfs.server.filesplitter.FileSplitService;
import net.dfs.user.connect.StorageConnectionHandler;

public class StorageConnectionHandlerImplementation implements StorageConnectionHandler{
	private FileSplitService split;
	
	public void StoreFile(FileInputStream fileStream) {
		
		System.out.println(fileStream);
		split.split(fileStream);
	}

	public void setSplit(FileSplitService split) {
		this.split = split;
	}
	
}
