<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Filière</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Ajouter une Filière</h1>
    <form:form action="${pageContext.request.contextPath}/filieres/save" method="post" modelAttribute="filiere">
        <div class="mb-3">
            <label for="nomFiliere" class="form-label">Nom de la Filière:</label>
            <form:input path="nomFiliere" class="form-control" id="nomFiliere" required="true"/>
        </div>
        <button type="submit" class="btn btn-success">Enregistrer</button>
        <a href="<c:url value='/filieres/list'/>" class="btn btn-secondary">Annuler</a>
        <a href="<c:url value='/etudiants/list'/>" class="btn btn-primary">Retourner vers etudiants</a>

    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>