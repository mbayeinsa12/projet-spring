<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Notes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Liste des Notes</h1>
    <a href="<c:url value='/notes/add'/>" class="btn btn-primary mb-3">Ajouter une Note</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Valeur</th>
            <th>Étudiant</th>
            <th>Cours</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="note" items="${notes}">
            <tr>
                <td>${note.id}</td>
                <td>${note.valeur}</td>
                <td>${note.etudiant != null ? note.etudiant.nom : 'N/A'} ${note.etudiant != null ? note.etudiant.prenom : ''}</td>
                <td>${note.cours != null ? note.cours.titre : 'N/A'}</td>
                <td>
                    <a href="<c:url value='/notes/edit/${note.id}'/>" class="btn btn-warning btn-sm">Modifier</a>
                    <form action="<c:url value='/notes/delete/${note.id}'/>" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette note ?');">Supprimer</button>
                        <a href="<c:url value='/etudiants/list'/>" class="btn btn-primary">Retourner vers etudiants</a>
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