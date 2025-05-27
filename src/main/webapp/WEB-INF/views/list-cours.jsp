<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Cours</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Liste des Cours</h1>
    <a href="<c:url value='/cours/add'/>" class="btn btn-primary mb-3">Ajouter un Cours</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Crédit</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${cours}">
            <tr>
                <td>${cours.id}</td>
                <td>${cours.titre}</td>
                <td>${cours.credit}</td>
                <td>
                    <a href="<c:url value='/cours/edit/${cours.id}'/>" class="btn btn-warning btn-sm">Modifier</a>
                    <form action="<c:url value='/cours/delete/${cours.id}'/>" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce cours ?');">Supprimer</button>
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