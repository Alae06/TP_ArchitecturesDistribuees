<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.estn.model.Client" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h1>Liste des Clients</h1>
    
    <!-- Bouton pour ajouter un client -->
    <a href="client?action=add" class="btn btn-primary mb-3">Ajouter un Client</a>
    
    <!-- Tableau des clients -->
    <table class="table table-striped">
        <thead>
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
                // On récupère la liste des clients
                List<Client> clients = (List<Client>) request.getAttribute("clients");
                
                // Si la liste n'est pas vide
                if (clients != null && !clients.isEmpty()) {
                    // On affiche chaque client
                    for (Client client : clients) {
            %>
                <tr>
                    <td><%= client.getId() %></td>
                    <td><%= client.getNom() %></td>
                    <td><%= client.getPrenom() %></td>
                    <td><%= client.getAge() %></td>
                    <td>
                        <a href="client?action=edit&id=<%= client.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                        <a href="client?action=delete&id=<%= client.getId() %>" class="btn btn-danger btn-sm" 
                           onclick="return confirm('Voulez-vous vraiment supprimer ce client ?')">Supprimer</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5" class="text-center">Aucun client trouvé</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>