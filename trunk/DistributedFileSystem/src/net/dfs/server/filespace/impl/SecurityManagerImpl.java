/**
 * 
 */
package net.dfs.server.filespace.impl;

import java.rmi.RMISecurityManager;

import net.dfs.server.filespace.SecurityManager;

/**
 * @author Rukshan
 *
 */
public class SecurityManagerImpl implements SecurityManager{
	
	public void securityM() {
		try {
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new RMISecurityManager());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
