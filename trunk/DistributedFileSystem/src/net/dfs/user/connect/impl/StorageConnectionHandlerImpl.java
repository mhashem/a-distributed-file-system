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

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dfs.server.noderegistration.UserRegistrationService;
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
	private UserRegistrationService userRegistration;
	private Log log = LogFactory.getLog(RetrievalConnectionHandlerImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	public void storeFile(long FILE_SIZE, String fileName, String ext, String user) {
		log.debug("The File "+fileName+ext+" With "+FILE_SIZE+" received by "+user);
		userRegistration.registerUserIP(fileName, user);

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

	public void setUserRegistration(UserRegistrationService userRegistration) {
		this.userRegistration = userRegistration;
	}
	
	
 }
