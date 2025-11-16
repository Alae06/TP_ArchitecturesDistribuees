<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.estn.ClientDAO" %>
<%@ page import="com.estn.Client" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Liste des Clients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    ClientDAO clientDAO = new ClientDAO();
    List<Client> clients;
    String searchTerm = request.getParameter("search");
    
    if (searchTerm != null && !searchTerm.trim().isEmpty()) {
        clients = clientDAO.rechercherClients(searchTerm);
    } else {
        clients = clientDAO.listerClients();
    }
%>

<div class="container mt-5">
  <div class="card shadow-sm">
    <div class="card-header bg-primary text-white">
      Liste des Clients
    </div>

    <div class="card-body">
      <form class="row g-2 mb-3" method="GET">
        <div class="col-auto">
          <label class="col-form-label">Client :</label>
        </div>
        <div class="col-auto">
          <input type="text" name="search" class="form-control" placeholder="Nom du client" value="<%= searchTerm != null ? searchTerm : "" %>">
        </div>
        <div class="col-auto">
          <button type="submit" class="btn btn-primary" >Chercher</button>
        </div>
        <div class="col-auto">
          <a href="index.html" class="btn btn-warning text-white">Nouveau Client</a>
        </div>
      </form>

      <table class="table table-bordered align-middle">
        <thead class="table-light">
          <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Âge</th>
          </tr>
        </thead>
        <tbody>
          <% if (clients.isEmpty()) { %>
            <tr>
              <td colspan="6" class="text-center text-muted">Aucun client trouvé</td>
            </tr>
          <% } else { %>
            <% for (Client client : clients) { %>
              <tr>
                <td><%= client.getId() %></td>
                <td><%= client.getNom() %></td>
                <td><%= client.getPrenom() %></td>
                <td><%= client.getAge() %></td>
                <td class="text-center">
                  <a href="editClient.jsp?id=<%= client.getId() %>" class="btn btn-sm btn-outline-primary">Modifier</a>
                </td>
                <td class="text-center">
                  <a href="deleteClient.jsp?id=<%= client.getId() %>" class="btn btn-sm btn-outline-danger" 
                     onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce client ?')">Supprimer</a>
                </td>
              </tr>
            <% } %>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>