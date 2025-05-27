<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Filières</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Liste des Filières</h1>
    <a href="<c:url value='/filieres/add'/>" class="btn btn-primary mb-3">Ajouter une Filière</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom de la Filière</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="filiere" items="${filieres}">
            <tr>
                <td>${filiere.id}</td>
                <td>${filiere.nomFiliere}</td>
                <td>
                    <a href="<c:url value='/filieres/edit/${filiere.id}'/>" class="btn btn-warning btn-sm">Modifier</a>
                    <form action="<c:url value='/filieres/delete/${filiere.id}'/>" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette filière ?');">Supprimer</button>
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