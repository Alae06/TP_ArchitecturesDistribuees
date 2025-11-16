package com.estn.model;

import java.sql.*;
import java.util.*;


public class ClientDAO {
    
    private String url = "jdbc:mysql://localhost:3306/ilcs";
    private String user = "root";
    private String password = "";

    public ClientDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Erreur driver MySQL: " + e.getMessage());
        }
    }

    public void ajouterClient(Client client) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "INSERT INTO client (Nom, Prenom, Age) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setInt(3, client.getAge());
            
            ps.executeUpdate();
            
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Erreur ajout client: " + e.getMessage());
        }
    }

    public List<Client> listerClients() {
        List<Client> clients = new ArrayList<Client>();
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "SELECT * FROM client";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("IdClient"));
                client.setNom(rs.getString("Nom"));
                client.setPrenom(rs.getString("Prenom"));
                client.setAge(rs.getInt("Age"));
                clients.add(client);
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Erreur liste clients: " + e.getMessage());
        }
        
        return clients;
    }

    public Client getClientById(int id) {
        Client client = null;
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "SELECT * FROM client WHERE IdClient = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("IdClient"));
                client.setNom(rs.getString("Nom"));
                client.setPrenom(rs.getString("Prenom"));
                client.setAge(rs.getInt("Age"));
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Erreur récupération client: " + e.getMessage());
        }
        
        return client;
    }

    public void modifierClient(Client client) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "UPDATE client SET Nom=?, Prenom=?, Age=? WHERE IdClient=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setInt(3, client.getAge());
            ps.setInt(4, client.getId());
            
            ps.executeUpdate();
            
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Erreur modification client: " + e.getMessage());
        }
    }

    public void supprimerClient(int id) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "DELETE FROM client WHERE IdClient = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Erreur suppression client: " + e.getMessage());
        }
    }
}