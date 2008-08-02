package net.dfs.ui;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

public class TextAreaAppender extends WriterAppender{

	static private JTextArea textArea = null;

	public static void setTextArea(JTextArea textArea) {
		TextAreaAppender.textArea = textArea;
	}
	
	public void append(LoggingEvent loggingEvent){
		final String message = this.layout.format(loggingEvent);
		
		if (textArea == null) return;
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				textArea.append(message);
			}
		});
	}
}
