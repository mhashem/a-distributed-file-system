package net.dfs.user.test;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServicesStarter {

	public static void main(String args []) throws FileNotFoundException{
		
		new ClassPathXmlApplicationContext("net\\dfs\\user\\test\\spring-user.xml");
		System.out.print("USER started");
	}
}
