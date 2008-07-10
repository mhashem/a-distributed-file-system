package net.dfs.user.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.context.ApplicationContext;

import net.dfs.server.filesplitter.FileSplitService;
import net.dfs.user.connect.StorageConnectionHandler;
import net.dfs.user.connect.impl.StorageConnectionHandlerImpl;

public class Test {

	private static StorageConnectionHandler store;

	public static void main(String args[]) throws FileNotFoundException{
		
		FileInputStream fileIn = new FileInputStream("C:\\Done.txt");
		System.out.println("Created...");
		store.StoreFile(fileIn);
	}

	public static void setStore(StorageConnectionHandler store) {
		Test.store = store;
	}

	public static StorageConnectionHandler getStore() {
		return store;
	}


}
