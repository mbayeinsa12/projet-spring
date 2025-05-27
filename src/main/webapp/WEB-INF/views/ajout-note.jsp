<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Note</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Ajouter une Note</h1>
    <form:form action="${pageContext.request.contextPath}/notes/save" method="post" modelAttribute="note">
        <div class="mb-3">
            <label for="valeur" class="form-label">Valeur:</label>
            <form:input type="number" step="0.01" path="valeur" class="form-control" id="valeur" required="true"/>
        </div>
        <div class="mb-3">
            <label for="etudiant" class="form-label">Étudiant:</label>
            <select class="form-select" id="etudiant" name="etudiantId" required>
                <option value="">-- Sélectionnez un Étudiant --</option>
                <c:forEach var="etudiant" items="${etudiants}">
                    <option value="${etudiant.id}">${etudiant.nom} ${etudiant.prenom}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="cours" class="form-label">Cours:</label>
            <select class="form-select" id="cours" name="coursId" required>
                <option value="">-- Sélectionnez un Cours --</option>
                <c:forEach var="cours" items="${coursList}">
                    <option value="${cours.id}">${cours.titre}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Enregistrer</button>
        <a href="<c:url value='/notes/list'/>" class="btn btn-secondary">Annuler</a>

    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>