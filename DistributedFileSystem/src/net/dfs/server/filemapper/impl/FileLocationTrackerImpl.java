/**
 * Copyright 2008 Rukshan Silva
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations 
 * under the License.
 */

package net.dfs.server.filemapper.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.server.filemodel.HashModel;
import net.dfs.user.connect.RetrievalConnectionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Implementation of the {@link FileLocationTracker} which will keep track of the 
 * File object Name and the remote storage machine. It will use a HashMap for the 
 * persistent storage of the associativities.
 * <p>
 * Each location of the File objects are being used in retrieving the File. So 
 * {@link RetrievalConnectionHandler} will use this Map to find the location of the 
 * each Files.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class FileLocationTrackerImpl implements FileLocationTracker{
	protected static final long DURATION = 50000;

	private Log log = LogFactory.getLog(FileLocationTrackerImpl.class);
	
	HashMap<String,String> hashMap = new HashMap<String,String>();


	@SuppressWarnings("unchecked")
	public void loadMap() {
		try {
			ObjectInputStream load = new ObjectInputStream(new FileInputStream(new File("locationMap")));
			hashMap = (HashMap<String,String>) load.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		log.info("Hash Map Loaded");

	}

	/**
	 * createHashIndex will insert each and every File Name and Location tuples into
	 * the newly created HashMap. It returns no value.
	 * {@inheritDoc}
	 */
	public void createHashIndex(String key, String value) {
		hashMap.put(key, value);
		log.debug("Key "+key+" and Value "+value+" Added to the HashMap");
	}

	public void deleteHashIndex(String key) {
		hashMap.remove(key);
		log.debug("Key "+key+" Removed from the HashMap");
	}
	/**
	 * {@inheritDoc}
	 */
	public void retrieveKeys() {
		
		Iterator <String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * getValues will add all the values which matches with the given key and 
	 * insert the result into a ArrayList and will return it.
	 * 
	 * {@inheritDoc}
	 */
	public HashModel[] getValues(String key, String ext){
		
		List<HashModel> list = new ArrayList<HashModel> ();
		
		for(int i=1;i<=hashMap.size();i++){	
			if(hashMap.containsKey(key+"_"+i+ext)){
				HashModel hashModel = new HashModel();
				
				hashModel.setKey(key+"_"+i+ext);
				hashModel.setValue(hashMap.get(key+"_"+i+ext));
				list.add(hashModel);
				log.info("Hash Map contains : " +key+"_"+i+ext);
			}
			else
				log.info("The requested File "+key+"_"+i+ext+" Not Found");
		}
		
		return list.toArray(new HashModel[] {});	
	}

	public void removeAll(){
		hashMap.clear();
	}

	public void saveMap() {
			new Thread(new Runnable(){
				public void run(){
					ObjectOutputStream save;
					while(true){
						try {
							save = new ObjectOutputStream(new FileOutputStream(new File("locationMap")));
							save.writeObject(hashMap);
	
							Thread.sleep(DURATION);
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					log.info("Hash Map Saved");
					}
				}
			}).start();
		
	}
	
	
 }
