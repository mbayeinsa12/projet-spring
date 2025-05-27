<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Étudiants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Liste des Étudiants</h1>
    <a href="<c:url value='/etudiants/add'/>" class="btn btn-primary mb-3">Ajouter un Étudiant</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Date de Naissance</th>
            <th>Filière</th>
            <th>Cours Inscrits</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="etudiant" items="${etudiants}">
            <tr>
                <td>${etudiant.id}</td>
                <td>${etudiant.nom}</td>
                <td>${etudiant.prenom}</td>
                <td>${etudiant.dateNaissance}</td>
                <td>${etudiant.filiere != null ? etudiant.filiere.nomFiliere : "N/A"}</td>
                <td>
                    <c:forEach var="cours" items="${etudiant.coursInscrits}">
                        ${cours.titre}<br/>
                    </c:forEach>
                </td>
                <td>
                    <a href="<c:url value='/etudiants/edit/${etudiant.id}'/>" class="btn btn-warning btn-sm">Modifier</a>
                    <form action="<c:url value='/etudiants/delete/${etudiant.id}'/>" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?');">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>