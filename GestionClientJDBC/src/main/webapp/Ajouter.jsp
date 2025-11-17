<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ilcs2", "root", "");

    if(request.getMethod().equals("POST")) {
        int id = Integer.parseInt(request.getParameter("idClient"));
        String nom = request.getParameter("Nom");
        String prenom = request.getParameter("Prenom");
        int age = Integer.parseInt(request.getParameter("Age"));

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

        response.sendRedirect("Liste.jsp");
        
        
    }
    conn.close();

} catch(SQLException e) {
    e.printStackTrace();
}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Nouveau Client</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
  <div class="card border-primary w-75">
    <div class="card-header bg-primary text-white py-2">
      <strong class="fs-4">Nouveau Client</strong>
    </div>
    <div class="card-body">
      <form method="POST" action="Ajouter.jsp">
        <div class="mb-3">
          <label class="form-label">id Client :</label>
          <input type="number" name="idClient" class="form-control" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Nom Client :</label>
          <input type="text" name="nom" class="form-control" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Prénom Client :</label>
          <input type="text" name="prenom" class="form-control" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Age :</label>
          <input type="number" name="age" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Ajouter</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>


