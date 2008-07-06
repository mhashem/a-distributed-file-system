package net.dfs.server.filemapper.impl;

import java.util.Enumeration;
import java.util.Hashtable;

import net.dfs.server.filemapper.MapFile;

public class MapFileImpl implements MapFile{
	private String key;
	private String value;
	
	Hashtable<String, String> hashtable = new Hashtable<String, String>();

	public void createHashIndex() {
		hashtable.put(this.key, this.value);
		

	}
	
	public static void main(String args[]){
		MapFileImpl map = new MapFileImpl();
		map.retreveKeys();
		System.out.println("All the Keys.... ");
	}	
	
	public void retreveKeys(){
		Enumeration<String> e = hashtable.keys();
				
		while(e.hasMoreElements()){
			System.out.println("All the Keys.... " + e.nextElement());
			
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
