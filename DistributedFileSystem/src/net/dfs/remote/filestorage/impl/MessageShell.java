package net.dfs.remote.filestorage.impl;

import net.dfs.server.filemodel.Message;
import net.dfs.server.filespace.creator.SecurityManager;
import net.dfs.server.filespace.creator.SpaceAccessor;
import net.dfs.server.filespace.creator.SpaceHost;
import net.dfs.server.filespace.creator.impl.SpaceAccessorImpl;
import net.jini.space.JavaSpace;

public class MessageShell {

	private SpaceAccessor lookup;
	private JavaSpace space ;
	private SpaceHost spaceHost;
	public void readImpl() {
/*
		if(args.length < 2) {
			System.out.println("Usage java org.jworkplace.MessageShell " + hostname);
			System.exit(1);

		} 
		else {
			hostname = args[0];
		}*/

		try {
			
			space = lookup.getSpace(spaceHost.getHostAddress());

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

	public void setLookup(SpaceAccessor lookup) {
		this.lookup = lookup;
	}

	public void setSpaceHost(SpaceHost spaceHost) {
		this.spaceHost = spaceHost;
	}

	
}
