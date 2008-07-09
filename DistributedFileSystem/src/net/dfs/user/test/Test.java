package net.dfs.user.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import net.dfs.user.connect.StorageConnectionHandler;
import net.dfs.user.connect.impl.StorageConnectionHandlerImplementation;

public class Test {

	public static void main(String args[]) throws FileNotFoundException{
		String fileName = "C:\\Done.txt" ;
		StorageConnectionHandler store = new StorageConnectionHandlerImplementation();

		store.StoreFile(new FileInputStream(fileName));
	}
}
