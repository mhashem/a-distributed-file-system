package net.dfs.user.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import net.dfs.user.connect.StorageConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[])throws FileNotFoundException{
		String FileName = "C:\\Done.txt";
		byte b[] = FileName.getBytes();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");

		StorageConnectionHandler storageHandler = (StorageConnectionHandler)context.getBean("storageHandler");
		
		storageHandler.StoreFile(b);

	}

}
