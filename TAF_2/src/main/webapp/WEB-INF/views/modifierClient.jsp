<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.estn.model.Client" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier un Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h1>Modifier un Client</h1>
    
    <%
        // On récupère le client à modifier
        Client client = (Client) request.getAttribute("client");
        
        if (client != null) {
    %>
        <!-- Formulaire pour modifier un client -->
        <form method="POST" action="client">
            <!-- Champ caché pour indiquer l'action -->
            <input type="hidden" name="action" value="edit">
            <!-- Champ caché pour l'ID du client -->
            <input type="hidden" name="id" value="<%= client.getId() %>">
            
            <div class="mb-3">
                <label for="nom" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="nom" name="nom" value="<%= client.getNom() %>" required>
            </div>
            
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom :</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="<%= client.getPrenom() %>" required>
            </div>
            
            <div class="mb-3">
                <label for="age" class="form-label">Âge :</label>
                <input type="number" class="form-control" id="age" name="age" value="<%= client.getAge() %>" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Modifier</button>
            <a href="client" class="btn btn-secondary">Retour</a>
        </form>
    <%
        } else {
    %>
        <div class="alert alert-warning">Client introuvable</div>
        <a href="client" class="btn btn-primary">Retour à la liste</a>
    <%
        }
    %>
</div>

</body>
</html>