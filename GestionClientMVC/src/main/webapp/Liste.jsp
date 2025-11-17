<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.estn.model.Client"%>
<%@ page import="java.util.List"%>

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
      <form method="get" action="Liste.php" class="d-flex mb-3">
        <input type="text" name="motCle" class="form-control w-50 me-2"
               placeholder="Entrez un nom..."
               value="<%= request.getParameter("motCle") != null ? request.getParameter("motCle") : "" %>">
        <button type="submit" class="btn btn-primary me-2">Chercher</button>
        <a href="Ajouter.php" class="btn btn-warning text-white">Nouveau Client</a>
      </form>

      <table class="table table-bordered table-hover text-center align-middle">
        <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Âge</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
        <%
          List<Client> clients = (List<Client>) request.getAttribute("clients");
        
          if (clients != null) {
              for (Client c : clients) {
        %>
          <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNom() %></td>
            <td><%= c.getPrenom() %></td>
            <td><%= c.getAge() %></td>
            <td>
              <a href="Modifier.php?id=<%= c.getId() %>" class="btn btn-info btn-sm">Modifier</a>
              <a href="Supprimer.php?id=<%= c.getId() %>" class="btn btn-danger btn-sm"
                 onclick="return confirm('Supprimer ce client ?');">Supprimer</a>
            </td>
          </tr>
        <% } } %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>



