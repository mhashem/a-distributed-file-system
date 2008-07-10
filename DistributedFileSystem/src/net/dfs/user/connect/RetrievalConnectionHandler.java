package net.dfs.user.connect;

import net.dfs.remote.fileretrieve.RetrievalManager;


public interface RetrievalConnectionHandler {

	public abstract RetrievalManager createProxy();
	public void retrieveFile();
}
