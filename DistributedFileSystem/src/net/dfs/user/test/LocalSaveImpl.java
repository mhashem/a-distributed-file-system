package net.dfs.user.test;

import net.dfs.server.filemodel.FileRetrievalModel;

public class LocalSaveImpl implements LocalSave{
	
	public void saveFile(FileRetrievalModel file){

		System.out.println("HI LOCAL FILE !!!!!!!!!!!!!!!!!!!!!");
		System.out.println(file.fileName);
	}
}
