package net.dfs.server.filemodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCreator {

	private BufferedInputStream bufferedInputStream;
	private BufferedOutputStream bufferedOutputStream;

	public BufferedInputStream getBufferedInputStream() {
		return bufferedInputStream;
	}

	public void setBufferedInputStream(String fileName) {
		try {
			this.bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedOutputStream getBufferedOutputStream() {
		return bufferedOutputStream;
	}
	
	public void setBufferedOutputStream(String fileName) {
		try {
			this.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
