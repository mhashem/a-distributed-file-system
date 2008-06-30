/**
 * 
 */
package net.dfs.server.splitfile.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.filemodel.FileModel;
import net.dfs.server.filespace.FileSpace;
import net.dfs.server.filespace.impl.FileSpaceImpl;
import net.dfs.server.splitfile.SplitFile;

/**
 * @author Rukshan
 *
 */
public class SplitFileImpl implements SplitFile {
	
	private FileModel fileModel;
	private FileSpace fileSpace;
	private String fileName;
	private Log log = LogFactory.getLog(SplitFileImpl.class);

	public void split() {
		
		fileModel.setBufferedInputStream(fileName);

		byte [] buffer = new byte [1024];
		int bytesRead = 0, increment = 0;
		

		try {
			fileSpace.fileSpace();

			while((bytesRead = fileModel.getFis().read(buffer)) != -1){
				increment += 1;
				fileModel.setName("D:\\Working\\Done_"+increment+".txt");
				fileModel.setBytesRead(bytesRead);
				fileModel.setB(buffer);
				
				fileSpace.writeToSpace(fileModel);
				log.debug("-- File " + fileModel.getName() + " Send to the Space");

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

	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
	}

	public void setFileSpace(FileSpace fileSpace) {
		this.fileSpace = fileSpace;
	}
	
	
}
