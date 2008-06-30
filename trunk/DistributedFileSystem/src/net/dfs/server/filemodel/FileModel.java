/**
 * 
 */
package net.dfs.server.filemodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import net.jini.core.entry.Entry;

/**
 * @author Rukshan
 *
 */
public class FileModel implements Entry{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	InputStream fis;
	OutputStream fout;
	String name;
	int bytesRead;
	byte [] b;
		
	public InputStream getFis() {
		return fis;
	}
	
	public void setFis(File file) {
		try {
			this.fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public OutputStream getFout() {
		return fout;
	}

	public void setFout(String fileName) {
		try {
			this.fout = new FileOutputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
	public int getBytesRead() {
		return bytesRead;
	}
	
	public void setBytesRead(int bytesRead) {
		this.bytesRead = bytesRead;
	}

	public byte[] getB() {
		return b;
	}

	public void setB(byte[] b) {
		this.b = b;
	}	
}
