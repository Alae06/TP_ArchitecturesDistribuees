package com.estn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.estn.dao.IClientDao;
import com.estn.dao.entities.Client;
import com.estn.dao.utilis.MaConnection;

@Component
public class ClientDaoImpl implements IClientDao {

	@Override
	public void saveClient(Client client) {
		Connection connection = MaConnection.getConnection();
		String sql = "INSERT INTO client (Nom, Prenom, Age) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,client.getNom());
			ps.setString(2,client.getPrenom());
			ps.setInt(3,client.getAge());
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateClient(Client client, Long id) {
		Connection connection = MaConnection.getConnection();
		String sql = "Update client set Nom =? , Prenom=? , Age=? WHERE IdClient=? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,client.getNom());
			ps.setString(2,client.getPrenom());
			ps.setInt(3,client.getAge());
			ps.setLong(4,id);
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteClient(Long id) {
		Connection connection = MaConnection.getConnection();
		String sql = "DELETE FROM client WHERE IdClient= ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong(1,id);
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Client getClient(Long id) {
		Client client =new Client();
		
		
		Connection connection = MaConnection.getConnection();
		String sql = "SELECT * FROM client WHERE IdClient= ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				client.setId(rs.getLong("IdClient"));
				client.setNom(rs.getString("Nom"));
				client.setPrenom(rs.getString("Prenom"));
				client.setAge(rs.getInt("Age"));
				
			}
			
			rs.close();
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> getClients() {
        List<Client> clients =new ArrayList<Client>();
		
		
		Connection connection = MaConnection.getConnection();
		String sql = "SELECT * FROM client";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client client =new Client();
				
				client.setId(rs.getLong("IdClient"));
				client.setNom(rs.getString("Nom"));
				client.setPrenom(rs.getString("Prenom"));
				client.setAge(rs.getInt("Age"));
				
				clients.add(client);
				
			}
			
			rs.close();
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public List<Client> searchClientByName(String motCle) {
List<Client> clients =new ArrayList<Client>();
		
		
		Connection connection = MaConnection.getConnection();
		String sql = "SELECT * FROM client WHERE Nom LIKE ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%"+motCle+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client client =new Client();
				
				client.setId(rs.getLong("IdClient"));
				client.setNom(rs.getString("Nom"));
				client.setPrenom(rs.getString("Prenom"));
				client.setAge(rs.getInt("Age"));
				
				clients.add(client);
				
			}
			
			rs.close();
			ps.executeUpdate();
			
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}

}
