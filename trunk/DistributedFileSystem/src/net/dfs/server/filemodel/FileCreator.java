package net.dfs.server.filemodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCreator {
	private static BufferedOutputStream outputStream;
	
	public static BufferedInputStream BufferedInputStreamCreator(FileInputStream file) {
		return new BufferedInputStream(file);
	}

	public static BufferedOutputStream getOutputStream() {
		return outputStream;
	}

	public static void setOutputStream(FileOutputStream fileOutputStream) {
		FileCreator.outputStream = new BufferedOutputStream(fileOutputStream);
	}

	
}
