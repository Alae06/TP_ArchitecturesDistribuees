package com.estn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeDaoImpl {
	

	public Employe getEmploye(long id) {
		Employe  employe = new Employe();
	
		String url_db = "jdbc:mysql://localhost:3306/prime";
		String user_db = "root";
		String pwd_db = "";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection(url_db, user_db, pwd_db);
		    PreparedStatement ps = connection.prepareStatement("Select * FROM employe WHERE id =?");
	        ps.setLong(1, id);
	        ResultSet rs= ps.executeQuery();
	        while (rs.next()) {
	        	
	        	employe.setId(rs.getInt("id"));
	        	employe.setNom(rs.getString("nom"));
	        	employe.setPrenom(rs.getString("prenom"));
	        	employe.setSalaire(rs.getDouble("salaire"));
	        	employe.setEmbauche(rs.getDate("d_embauche"));
	        	
			}
	        
	        rs.close();
	        ps.close();
	        connection.close();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return employe;
}


}
