<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ilcs2", "root", "");

  String motCle = request.getParameter("motCle");
  if (motCle == null) motCle = ""; 

String rt = "SELECT * FROM client WHERE Nom LIKE ?";
PreparedStatement ps = conn.prepareStatement(rt);
ps.setString(1, "%" + motCle + "%");

ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="card">
    <div class="card-header bg-primary text-white">
      <h4>Liste des Clients</h4>
    </div>

    <div class="card-body">
      <form method="GET" class="d-flex mb-3">
        <input type="text" name="motCle" class="form-control w-50 me-2" placeholder="Entrez un nom..." value="<%= motCle %>">
        <button type="submit" class="btn btn-primary me-2">Chercher</button>
        <a href="Ajouter.jsp" class="btn btn-warning text-white">Nouveau Client</a>
      </form>

      <table class="table table-bordered table-hover text-center align-middle">
        <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Age</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <%
          while (rs.next()) {
          %>
            <tr>
              <td><%= rs.getInt("IdClient") %></td>
              <td><%= rs.getString("Nom") %></td>
              <td><%= rs.getString("Prenom") %></td>
              <td><%= rs.getInt("Age") %></td>
              <td>
                <a href="modifier.jsp?id=<%= rs.getInt("IdClient") %>" class="btn btn-info btn-sm">Éditer</a>
                <a href="supprimer.jsp?id=<%= rs.getInt("IdClient") %>" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Voulez-vous vraiment supprimer ce client ?');">
                   Supprimer
                </a>
              </td>
            </tr>
          <%
          }
          rs.close();
          ps.close();
          conn.close();
          %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
<% } catch(SQLException e) {
    e.printStackTrace();
}

%>
