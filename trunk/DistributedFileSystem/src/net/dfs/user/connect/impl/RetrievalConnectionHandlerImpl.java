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

import java.io.IOException;

import net.dfs.server.noderegistration.UserRegistrationService;
import net.dfs.server.retrievefile.FileRetrievalService;
import net.dfs.user.connect.RetrievalConnectionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of {@link RetrievalConnectionHandler}, the class given at the API to 
 * get connected with the User. It will re-direct the File Name to the 
 * {@link FileRetrievalService} which is been sent by the user.
 * 
 * @author Rukshan Silva
 * @version 1.0
 *
 */
 public class RetrievalConnectionHandlerImpl implements RetrievalConnectionHandler{
	private FileRetrievalService retrievalSrevice; 
	private UserRegistrationService userRegistration;
	private Log log = LogFactory.getLog(RetrievalConnectionHandlerImpl.class);
	
	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 */
	public void retrieveFile(String fileName, String ext,String user) throws IOException {
		log.debug("The User "+user+" requested for the File "+fileName+ext);
		userRegistration.registerUserIP(fileName+ext, user);

		retrievalSrevice.retrieveFile(fileName,ext);
	}

	/**
	 * setRetrievalSrevice will be used for the setter injection of the 
	 * Spring container. It injects the dependency with {@link FileRetrievalService}
	 * 
	 * @param retrievalSrevice is an object of type {@link FileRetrievalService}
	 */
	public void setRetrievalSrevice(FileRetrievalService retrievalSrevice) {
		this.retrievalSrevice = retrievalSrevice;
	}

	public void setUserRegistration(UserRegistrationService userRegistration) {
		this.userRegistration = userRegistration;
	}

	
 }
