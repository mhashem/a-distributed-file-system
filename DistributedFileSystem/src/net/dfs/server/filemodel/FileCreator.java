package net.dfs.server.filemodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCreator {

	private static BufferedInputStream bufferedInputStream;
	private static BufferedOutputStream bufferedOutputStream;

	public static BufferedInputStream getBufferedInputStream() {
		return bufferedInputStream;
	}

	public static void setBufferedInputStream(String fileName) {
		try {
			FileCreator.bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedOutputStream getBufferedOutputStream() {
		return bufferedOutputStream;
	}
	
	public static void setBufferedOutputStream(String fileName) {
		try {
			FileCreator.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
