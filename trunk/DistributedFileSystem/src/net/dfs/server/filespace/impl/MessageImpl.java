/**
 * 
 */
package net.dfs.server.filespace.impl;

import net.dfs.server.filespace.Message;
import net.jini.core.entry.Entry;

/**
 * @author Rukshan
 *
 */
public class MessageImpl implements Entry, Message{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String text;
	
	public MessageImpl(){
		
	}
	public MessageImpl(String text){
		super();
		this.text = text;
	}
}
