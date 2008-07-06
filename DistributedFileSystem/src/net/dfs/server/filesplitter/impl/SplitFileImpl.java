/**
 * 
 */
package net.dfs.server.filesplitter.impl;

import java.io.IOException;

import net.dfs.server.filemodel.FileCreator;
import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.creator.FileSpace;
import net.dfs.server.filesplitter.SplitFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SplitFileImpl implements SplitFile {
	
	private FileCreator fileCreator;
	private FileSpace fileSpace;
	private String fileName;
	private Log log = LogFactory.getLog(SplitFileImpl.class);

	public void split() {
		
		FileCreator.setBufferedInputStream(fileName);

		byte [] buffer = new byte [1024];
		Integer bytesRead = 0, increment = 0;
		

		try {
			fileSpace.fileSpace();
			FileModel fileModel = new FileModel();
			
			while((bytesRead = FileCreator.getBufferedInputStream().read(buffer)) != -1){
				increment += 1;
				fileModel.fileName = "D:\\Working\\Done_"+increment+".txt";
				fileModel.bytesRead = bytesRead;
				fileModel.bytes = buffer;
				
				fileSpace.writeToSpace(fileModel);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSpace(FileSpace fileSpace) {
		this.fileSpace = fileSpace;
	}

	public void setFileCreator(FileCreator fileCreator) {
		this.fileCreator = fileCreator;
	}


}
