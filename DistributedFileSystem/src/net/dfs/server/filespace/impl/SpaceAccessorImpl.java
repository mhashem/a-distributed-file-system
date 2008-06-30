/**
 * 
 */
package net.dfs.server.filespace.impl;
import net.dfs.server.filespace.Lookup;
import net.dfs.server.filespace.SecurityManager;
import net.dfs.server.filespace.SpaceAccessor;
/**
 * @author Rukshan Silva
 *
 */
public class SpaceAccessorImpl implements SpaceAccessor {
	
	public void space(){
		SecurityManager security =  new SecurityManagerImpl();
		security.securityM();
		Lookup lookup = new LookupImpl();
		((LookupImpl) lookup).setHostname("localhost");
		lookup.getSpace();
	}
}
