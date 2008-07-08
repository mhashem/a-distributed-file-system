package net.dfs.server.filemapper;

public interface MapFile {
	
	public void createHashIndex();

	public void retreveKeys();
	

	public String getKey();

	public void setKey(String key);

	public String getValue();

	public void setValue(String value);

}
