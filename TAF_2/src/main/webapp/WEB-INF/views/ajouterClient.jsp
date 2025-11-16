<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h1>Ajouter un Client</h1>
    
    <!-- Formulaire pour ajouter un client -->
    <form method="POST" action="client">
        <!-- Champ caché pour indiquer l'action -->
        <input type="hidden" name="action" value="add">
        
        <div class="mb-3">
            <label for="nom" class="form-label">Nom :</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        
        <div class="mb-3">
            <label for="prenom" class="form-label">Prénom :</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        
        <div class="mb-3">
            <label for="age" class="form-label">Âge :</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Ajouter</button>
        <a href="client" class="btn btn-secondary">Retour</a>
    </form>
</div>

</body>
</html>