<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value='/accueil'/>">Mon Application</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/etudiants/list'/>">Étudiants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/filieres/list'/>">Filières</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/cours/list'/>">Cours</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/notes/list'/>">Notes</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-4">
    <h1>Bienvenue à l'application de gestion universitaire!</h1>
    <p>Utilisez la barre de navigation ci-dessus pour gérer les étudiants, filières, cours et notes.</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>