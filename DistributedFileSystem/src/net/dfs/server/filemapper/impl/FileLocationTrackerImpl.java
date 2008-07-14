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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.dfs.server.filemapper.FileLocationTracker;
import net.dfs.user.connect.RetrievalConnectionHandler;
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
	
	HashMap<String,String> hashMap = new HashMap<String,String>();

	/**
	 * createHashIndex will insert each and every File Name and Location tuples into
	 * the newly created HashMap. It returns no value.
	 * {@inheritDoc}
	 */
	public void createHashIndex(String key, String value) {
		hashMap.put(key, value);
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
	public String[] getValues(String key){
		
		List<String> lst = new ArrayList<String> ();
		
		for(int i=0;i<hashMap.size();i++){	
			if(hashMap.containsKey(key+"_"+"i"+".txt")){
				lst.add(hashMap.get(key));
			}
		}
		return lst.toArray(new String[] {});	
	}
 }
