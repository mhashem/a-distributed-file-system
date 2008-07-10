package net.dfs.remote.fileretrieve.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import net.dfs.remote.fileretrieve.FileSenderSupport;
import net.dfs.remote.fileretrieve.RetrievalManager;
import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileRetrievalModel;

public class RetrievalManagerImpl implements RetrievalManager{

	private BufferedInputStream inputStream;
	private FileSenderSupport fileSender;
	
	public void retrieveFile(String fileName) {
		
			System.out.println("CALLED !!! - Retrieve");
		try {
			byte b[] = fileName.getBytes();
			inputStream = FileCreator.BufferedInputStreamCreator(b);

			byte[] buffer = new byte [inputStream.available()];
			Integer bytesRead = 0;
			
			fileSender.connectJavaSpace();
			FileRetrievalModel fileModel = new FileRetrievalModel();
			
			while((bytesRead = inputStream.read(buffer)) != -1){
				fileModel.fileName = fileName;	
				fileModel.fileName = fileName;
				fileModel.bytesRead = bytesRead;
				fileModel.bytes = buffer;
				
				System.out.println("CALLED !!! - Sending");
				fileSender.sendFile(fileModel);
				System.out.println("CALLED !!! - Sent");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setFileSender(FileSenderSupport fileSender) {
		this.fileSender = fileSender;
	}

}
