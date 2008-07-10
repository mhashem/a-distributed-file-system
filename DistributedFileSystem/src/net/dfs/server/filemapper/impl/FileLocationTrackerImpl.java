package net.dfs.server.filemapper.impl;

import java.util.HashMap;
import java.util.Iterator;

import net.dfs.server.filemapper.FileLocationTracker;

public class FileLocationTrackerImpl implements FileLocationTracker{
	
	HashMap<String,String> hashMap = new HashMap<String,String>();

	public void createHashIndex(String key, String value) {
		hashMap.put(key, value);

	}
	
	public static void main(String args[]){
	}	

	public void retrieveKeys() {
		Iterator <String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public String getValues(String key){
		
		for(int i=0;i<hashMap.size();i++){	
			if(hashMap.containsKey(key+"_"+"i"+".txt")){
			//	return hashMap.get(key);
				return "D:\\Working\\Done_11.txt";
			}
		}
		
	return "D:\\Working\\Done_11.txt";	
	}
}
