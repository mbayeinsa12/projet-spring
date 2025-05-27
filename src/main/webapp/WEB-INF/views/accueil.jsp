<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d'Accueil - Gestion Scolaire</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #004080;
            color: white;
            padding: 1rem;
            text-align: center;
        }
        main {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 2rem;
            padding: 2rem;
        }
        .card {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
            transition: 0.3s;
        }
        .card:hover {
            background-color: #e6f2ff;
            transform: translateY(-5px);
        }
        .card a {
            text-decoration: none;
            color: #004080;
            font-weight: bold;
        }
    </style>
</head>
<body>

<header>
    <h1>Bienvenue dans le Système de Gestion Scolaire</h1>
</header>

<main>
    <div class="card">
        <h2>Étudiants</h2>
        <a href="${pageContext.request.contextPath}/etudiants">Gérer les étudiants</a>
    </div>
    <div class="card">
        <h2>Filières</h2>
        <a href="${pageContext.request.contextPath}/filieres">Gérer les filières</a>
    </div>
    <div class="card">
        <h2>Cours</h2>
        <a href="${pageContext.request.contextPath}/cours">Gérer les cours</a>
    </div>
    <div class="card">
        <h2>Notes</h2>
        <a href="${pageContext.request.contextPath}/notes">Gérer les notes</a>
    </div>
</main>

</body>
</html>
