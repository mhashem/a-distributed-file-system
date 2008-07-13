package net.dfs.user.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.dfs.user.connect.StorageConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[])throws IOException{
		String fileName = "C:\\Done.txt";
		
		File f = new File(fileName);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		
		List<Byte> bytes = new ArrayList<Byte>();
		int b = -1;
		
		while ((b = in.read()) != -1) {
			bytes.add((byte) b);
		}
		
		byte[] filebytes = new byte[bytes.size()];
		
		for(int i=0; i< bytes.size(); i++) {
			filebytes[i] = bytes.get(i);
		}
		
		//byte b[] = filesName.getBytes();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");

		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");
		
		storageHandler.StoreFile(filebytes);


		for(int i=0;i<fileName.length();i++){
			if(fileName.charAt(i) == '.'){
				System.out.println("FILE NAME :"+fileName.substring(0,i));
				System.out.println("Extention :"+fileName.substring(i));
			}
		}

	}
	

}
