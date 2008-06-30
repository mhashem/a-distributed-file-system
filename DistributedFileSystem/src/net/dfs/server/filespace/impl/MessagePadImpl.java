/**
 * 
 */
package net.dfs.server.filespace.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.Message;
import net.dfs.server.filespace.SecurityManager;
import net.jini.core.entry.Entry;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;
/**
 * @author Rukshan
 *
 */
public class MessagePadImpl {

		public static void main(String args[]){
			String hostname = "localhost";
			
			SecurityManager security = new SecurityManagerImpl();
			security.securityM();
			
			Lookup lookup = new LookupImpl();
			((LookupImpl) lookup).setHostname(hostname);
			
			JavaSpace space = lookup.getSpace();
			
			if(space != null){
				//read input from console
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
				//create a message entry
				Message msg = new MessageImpl();
								
				try {
					while ((line = reader.readLine()).length() > 0) {
						// set the message text
						((MessageImpl) msg).text = line;
						// write a message per line entered
						space.write((Entry) msg, null, Long.MAX_VALUE);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				// we were unable to find the JavaSpaces service specified
				System.out.println("Unable to find ");
				System.exit(1);
			}

		}
}
