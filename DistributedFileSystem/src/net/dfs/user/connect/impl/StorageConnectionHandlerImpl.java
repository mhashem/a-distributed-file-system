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

package net.dfs.user.connect.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import net.dfs.server.token.TokenService;
import net.dfs.user.connect.StorageConnectionHandler;

/**
 * Implementation of the {@link StorageConnectionHandler}, provides the 
 * persistent storage in the distributed network.
 * 
 * @author Rukshan Silva
 * @version 1.0
 */
 public class StorageConnectionHandlerImpl implements StorageConnectionHandler{
	private TokenService tokenService;
	
	/**
	 * {@inheritDoc}
	 */
	public void storeFile(long FILE_SIZE, String fileName, String ext, InetAddress user) {
		Properties props = new Properties();

		try {
			props.load(new FileInputStream("server.properties"));
			props.put("user.ip", user.getHostAddress());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tokenService.createToken(FILE_SIZE, fileName, ext);
	}

	/**
	 * setTokenService will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link TokenService}
	 * 
	 * @param tokenService is an object of type {@link TokenService}
	 */
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
 }
