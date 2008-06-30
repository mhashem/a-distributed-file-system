/**
 * 
 */
package net.dfs.server.filespace.impl;

import java.io.IOException;

import net.dfs.server.filespace.Lookup;
import net.jini.core.discovery.LookupLocator;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.space.JavaSpace;

/**
 * @author Rukshan
 *
 */
public class LookupImpl implements Lookup{

	private String hostname;
	
	@SuppressWarnings("unchecked")
	public JavaSpace getSpace() {
		try {
			LookupLocator lookup = new LookupLocator("jini://" + hostname);
			System.out.println("SpaceAccessor using locater: "+lookup);
			ServiceRegistrar registrar = lookup.getRegistrar();

			Class[] types = new Class[]{JavaSpace.class};
			System.out.println("Entries Created");

			JavaSpace space = (JavaSpace) registrar.lookup(new ServiceTemplate(null,types,null));
			System.out.println("Space Created");
			
			return space;
			
		} catch (IOException e) {
			e.printStackTrace();
    	    System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
    	    System.exit(1);
		}
		return null;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	
}
