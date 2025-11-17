package com.estn.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private final String url = "jdbc:mysql://localhost:3306/ilcs"; 
    private final String user = "root";
    private final String pwd = "";

    public List<Client> getClients(String motCle) {
        List<Client> clients = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);

            PreparedStatement ps;
            if (motCle == null || motCle.isEmpty()) {
                ps = conn.prepareStatement("SELECT * FROM client"); 
            } else {
                ps = conn.prepareStatement("SELECT * FROM client WHERE Nom LIKE ?");
                ps.setString(1, "%" + motCle + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Client(
                    rs.getInt("IdClient"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getInt("Age")
                ));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void ajouterClient(int id, String nom, String prenom, int age) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO client(IdClient, Nom, Prenom, Age) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, id);
            ps.setString(2, nom);
            ps.setString(3, prenom);
            ps.setInt(4, age);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void modifierClient(int id, String nom, String prenom, int age) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE client SET Nom=?, Prenom=?, Age=? WHERE IdClient=?"
            );
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void supprimerClient(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM client WHERE IdClient=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Client getClientById(int id) {
        Client c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE IdClient=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client(
                    rs.getInt("IdClient"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getInt("Age")
                );
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return c;
    }
}

