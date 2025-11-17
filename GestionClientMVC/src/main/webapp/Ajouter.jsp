<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
    <div class="card border-primary w-75">
        <div class="card-header bg-primary text-white py-2">
            <strong class="fs-4">Ajouter un client</strong>
        </div>
        <div class="card-body">
            <form method="POST" action="Ajouter.php">
                <div class="mb-3">
                    <label class="form-label">ID Client :</label>
                    <input type="number" name="idClient" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Nom :</label>
                    <input type="text" name="nom" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Prénom :</label>
                    <input type="text" name="prenom" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Âge :</label>
                    <input type="number" name="age" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="Liste.php" class="btn btn-secondary ms-2">Retour à la liste</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>



    