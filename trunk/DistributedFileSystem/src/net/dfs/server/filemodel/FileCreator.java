package net.dfs.server.filemodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCreator {
	
	public static BufferedInputStream BufferedInputStreamCreator(byte file []) {
		return (new BufferedInputStream(new ByteArrayInputStream(file)));
	}

	public static BufferedOutputStream BufferedOutputStreamCreator(String fileName) {
		try {
			return (new BufferedOutputStream(new FileOutputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
