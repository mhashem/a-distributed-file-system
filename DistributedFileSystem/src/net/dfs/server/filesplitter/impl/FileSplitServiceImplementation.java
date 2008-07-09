/**
 * 
 */
package net.dfs.server.filesplitter.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.accessor.FileSpaceAccessor;
import net.dfs.server.filesplitter.FileSplitService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileSplitServiceImplementation implements FileSplitService {
	
	private BufferedInputStream inputStream;
	private FileSpaceAccessor spaceAccessor;
	private Log log = LogFactory.getLog(FileSplitServiceImplementation.class);

	public void split(FileInputStream fileStream) {
		
		inputStream = FileCreator.BufferedInputStreamCreator(fileStream);

		byte [] buffer = new byte [1024];
		Integer bytesRead = 0, increment = 0;
		

		try {
			spaceAccessor.fileSpace();
			FileModel fileModel = new FileModel();
			
			while((bytesRead = inputStream.read(buffer)) != -1){
				increment += 1;
				fileModel.fileName = "D:\\Working\\Done_"+increment+".txt";
				fileModel.bytesRead = bytesRead;
				fileModel.bytes = buffer;
				
				spaceAccessor.writeToSpace(fileModel);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setSpaceAccessor(FileSpaceAccessor spaceAccessor) {
		this.spaceAccessor = spaceAccessor;
	}

}
