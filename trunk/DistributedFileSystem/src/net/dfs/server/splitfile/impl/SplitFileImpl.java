/**
 * 
 */
package net.dfs.server.splitfile.impl;

import java.io.File;
import java.io.IOException;

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
	
	public void split() {
		
		fileModel.setFis(new File(this.fileName));

		byte [] buf = new byte [1024];
		int bytesRead = 0, i = 0;
		

		try {
			fileSpace.fileSpace();

			while((bytesRead = fileModel.getFis().read(buf)) != -1){
				i += 1;
				fileModel.setName("D:\\Working\\Done_"+i+".txt");
				fileModel.setBytesRead(bytesRead);
				fileModel.setB(buf);
				
				fileSpace.writeToSpace(fileModel);
				System.out.println("File " + fileModel.getName() + " Send to the Space");

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
