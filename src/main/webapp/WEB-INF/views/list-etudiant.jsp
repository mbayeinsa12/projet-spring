<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des Étudiants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<h1>Liste des Étudiants</h1>
<div class="table-container">
<table class="styled-table">
    <tr>
        <th>ID</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Téléphone</th>
        <th>Carte Étudiant</th>
        <th>Filière</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${etudiants}" var="etudiant">
        <tr>
            <td>${etudiant.id}</td>
            <td>${etudiant.prenom}</td>
            <td>${etudiant.nom}</td>
            <td>${etudiant.email}</td>
            <td>${etudiant.telephone}</td>
            <td>${etudiant.carteEtudiant}</td>
            <td>${etudiant.filiere.nom}</td>
            <td>
                <a href="/etudiants/edit/${etudiant.id}" class="btn btn-secondary">Modifier</a>
            </td>
            <td>
                <a href="/etudiants/delete/${etudiant.id}" class="btn btn-secondary">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/etudiants/new" class="btn btn-secondary">Ajouter un étudiant</a>
    </div>
</body>
</html>