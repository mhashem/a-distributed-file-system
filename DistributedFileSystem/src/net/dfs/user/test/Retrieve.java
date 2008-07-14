package net.dfs.user.test;

import net.dfs.user.connect.RetrievalConnectionHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Retrieve {

	public static void main(String args []){
		ApplicationContext context = new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		RetrievalConnectionHandler retrieve = (RetrievalConnectionHandler) context.getBean("retrieve");

		retrieve.retrieveFile("D:\\Working\\Done");
	}
}
