package net.dfs.server.filemodel;

import net.jini.entry.AbstractEntry;

public class Message extends AbstractEntry {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String text;
	public Message() { }

	public Message(String text) {
		super();
		this.text = text;
	}
}
