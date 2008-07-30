package net.dfs.server.filemodel;

import net.jini.entry.AbstractEntry;

public class FileToken extends AbstractEntry{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String fileName;
	public String ext;
	public Integer CHUNK_NO;

	public FileToken () {
		
	}

	public FileToken (String fileName,String ext) {
		super();
		this.fileName = fileName;
		this.ext = ext;
	}

	public FileToken (Integer CHUNK_NO) {
		super();
		this.CHUNK_NO = CHUNK_NO;
	}
	
	

}
