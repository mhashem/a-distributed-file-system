package net.dfs.user.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import net.dfs.server.filemodel.FileRetrievalModel;

public class LocalSaveImpl implements LocalSave{

	private String fileName;
	private String extention;
	private String path;
	boolean called = false;
	
	public void saveFile(FileRetrievalModel file){

		System.out.println("HI LOCAL FILE !!!!!!!!!!!!!!!!!!!!!");
		if(!called){
			fileNameAnalyzer(file.fileName);
			called = true;
		}
		try {
			ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(path+fileName+extention,true)));
			outputStream.write(file.bytes,0,file.bytesRead);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	private void fileNameAnalyzer(String file){

		String [] parts  = file.split("\\\\");
		String name = parts[parts.length-1];
		
		for(int i=0;i<name.length();i++){
			if(name.charAt(i) == '.'){
				this.fileName = name.substring(0,i-2);
				this.extention = name.substring(i);
			}
		}
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
