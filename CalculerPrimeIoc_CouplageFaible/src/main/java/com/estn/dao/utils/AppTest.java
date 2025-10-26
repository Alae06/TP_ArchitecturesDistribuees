package com.estn.dao.utils;

import java.sql.Connection;

public class AppTest {
	public static void main(String[] args) {
		
		System.out.println("---------------Singleton----------------");
		
		for (int i=1; 1<=5; i++) {
			Connection c =  MaConnection.getInstance();
		}
		
		System.out.println("---------------No Singleton----------------");
		for (int i=1; 1<=5; i++) {
			NoSingleton c =  new NoSingleton();
			c.getConnection();
			
		}
	}

}
