package net.dfs.server.filemapper;

public interface FileLocationTracker {
	
	public void createHashIndex(String key, String value);

	public void retrieveKeys();
	
	public String getValues(String key);


	
}
