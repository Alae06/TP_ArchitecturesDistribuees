package com.estn.dao.utilis;

import java.sql.Connection;
import java.sql.DriverManager;

public class MaConnection {
	private static Connection connection;
	
	static {
		System.out.println("-------------Initialisation de la connexion-----------");

		String url_db = "jdbc:mysql://localhost:3306/ilcs";
		String user_db = "root";
		String pwd_db = "";
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    connection = DriverManager.getConnection(url_db, user_db, pwd_db);
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private MaConnection() {
		
	}
	public static Connection getConnection() {
		return connection;
		
	}

}
