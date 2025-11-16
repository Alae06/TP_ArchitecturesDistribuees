package com.estn;


import java.sql.*;
import java.util.*;
import com.estn.Client;

public class ClientDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ilcs";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ajouterClient(Client c) {
        String sql = "INSERT INTO client (Nom, Prenom, Age) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listerClients() {
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("IdClient"));
                c.setNom(rs.getString("Nom"));
                c.setPrenom(rs.getString("Prenom"));
                c.setAge(rs.getInt("Age"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Client> rechercherClients(String motCle) {
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client WHERE Nom LIKE ? OR Prenom LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + motCle + "%");
            ps.setString(2, "%" + motCle + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("IdClient"));
                c.setNom(rs.getString("Nom"));
                c.setPrenom(rs.getString("Prenom"));
                c.setAge(rs.getInt("Age"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean modifierClient(Client c) {
        String sql = "UPDATE client SET Nom=?, Prenom=?, Age=? WHERE IdClient=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());
            ps.setInt(4, c.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification du client: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void supprimerClient(int id) {
        String sql = "DELETE FROM client WHERE IdClient = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
