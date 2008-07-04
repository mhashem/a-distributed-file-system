package net.dfs.client.storefile.impl;

import net.dfs.server.filemodel.Message;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.impl.LookupImpl;
import net.jini.space.JavaSpace;

public class MessageShell {

	private  SecurityManager security;
	private Lookup lookup;
	private JavaSpace space ;



		public void setSecurity(SecurityManager security) {
		this.security = security;
	}



	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}



		public void readImpl() {
		String hostname = "localhost";
/*
		if(args.length < 2) {
			System.out.println("Usage java org.jworkplace.MessageShell " + hostname);
			System.exit(1);

		} 
		else {
			hostname = args[0];
		}*/

		try {
			security.securityManager();
			
			((LookupImpl) lookup).setHostname(hostname);

			space = lookup.getSpace();

			if(space != null) {
				// Retrieve any Message in the space
				Message template = new Message();
				for(;;) {
					// take each message from the space
					// the call will block until a message arrives
					Message received =
					(Message)space.take(template, null ,
					Long.MAX_VALUE);
					System.out.println(received.text);
				}
			} 
			else {
				// we were unable to find the JavaSpaces service specified
				System.exit(1);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
