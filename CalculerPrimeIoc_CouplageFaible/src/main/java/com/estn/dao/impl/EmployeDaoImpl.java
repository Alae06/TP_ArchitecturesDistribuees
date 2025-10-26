package com.estn.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.estn.dao.IEmployeDao;
import com.estn.dao.entities.Employe;
import com.estn.dao.utils.MaConnection;

public class EmployeDaoImpl implements IEmployeDao{
	

	public Employe getEmploye(long id) {
		Employe  employe = new Employe();
	try {
		
		    Connection connection = MaConnection.getInstance();
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
	        
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return employe;
}


}
