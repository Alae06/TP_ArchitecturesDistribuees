<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    int clientId = Integer.parseInt(request.getParameter("IdClient"));
    String nomClient = "";
    String prenomClient = "";
    int ageClient = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ilcs2", "root", "");

        if(request.getMethod().equals("POST")) {
        	int Id = Integer.parseInt(request.getParameter("IdClient"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int age = Integer.parseInt(request.getParameter("Age"));

            PreparedStatement ps = conn.prepareStatement(
                "UPDATE Client SET Nom=?, Prenom=?, Age=? WHERE IdClient=?"
            );
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setInt(3, age);
            ps.setInt(4, clientId);
            ps.executeUpdate();
            ps.close();

            response.sendRedirect("Liste.jsp");
        }

        PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM Client WHERE IdClient=?");
        ps2.setInt(1, clientId);
        ResultSet rs = ps2.executeQuery();
        if(rs.next()){
            nomClient = rs.getString("Nom");
            prenomClient = rs.getString("Prenom");
            ageClient = rs.getInt("Age");
        }
        rs.close();
        ps2.close();
        conn.close();
    } 
    catch(ClassNotFoundException e) {
        e.printStackTrace();
    } catch(SQLException e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
  <div class="card border-primary w-75">
    <div class="card-header bg-primary text-white py-2">
      <strong class="fs-4">Modifier le client</strong>
    </div>
    <div class="card-body">
      <form method="POST">
        <input type="hidden" name="id" value="<%= clientId %>">
        <div class="mb-3">
          <label>Nom :</label>
          <input type="text" name="nom" class="form-control" value="<%= nomClient %>" required>
        </div>
        <div class="mb-3">
          <label>Prénom :</label>
          <input type="text" name="prenom" class="form-control" value="<%= prenomClient %>" required>
        </div>
        <div class="mb-3">
          <label>Age :</label>
          <input type="number" name="Age" class="form-control" value="<%= ageClient %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>

