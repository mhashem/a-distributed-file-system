package net.dfs.server.filemodel;

import net.jini.entry.AbstractEntry;

public class FileRetrievalModel extends AbstractEntry{
	
	private static final long serialVersionUID = 1L;
	
	public String fileName;
	public Integer bytesRead;
	public byte [] bytes;
	
	public FileRetrievalModel(){
		
	}
	
	public FileRetrievalModel(String fileName){
		super();
		this.fileName = fileName;
	}

	public FileRetrievalModel(Integer bytesRead){
		super();
		this.bytesRead = bytesRead;
	}

	public FileRetrievalModel(byte [] bytes){
		super();
		this.bytes = bytes;
	}
}
