<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Modifier un Étudiant</h1>
    <form:form action="${pageContext.request.contextPath}/etudiants/update" method="post" modelAttribute="etudiant">
        <form:hidden path="id"/> <%-- Hidden field for ID --%>
        <div class="mb-3">
            <label for="nom" class="form-label">Nom:</label>
            <form:input path="nom" class="form-control" id="nom" required="true"/>
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prénom:</label>
            <form:input path="prenom" class="form-control" id="prenom" required="true"/>
        </div>
        <div class="mb-3">
            <label for="dateNaissance" class="form-label">Date de Naissance:</label>
            <form:input type="date" path="dateNaissance" class="form-control" id="dateNaissance" required="true"/>
        </div>
        <div class="mb-3">
            <label for="filiere" class="form-label">Filière:</label>
            <form:select path="filiere.id" class="form-select" id="filiere">
                <form:option value="" label="-- Sélectionnez une Filière --" />
                <form:options items="${filieres}" itemValue="id" itemLabel="nomFiliere" />
            </form:select>
        </div>
        <div class="mb-3">
            <label for="coursInscrits" class="form-label">Cours Inscrits:</label>
            <select multiple class="form-select" id="coursInscrits" name="coursIds">
                <c:forEach var="cours" items="${allCours}">
                    <option value="${cours.id}"
                            <c:if test="${etudiant.coursInscrits.contains(cours)}">selected</c:if>
                    >${cours.titre}</option>
                </c:forEach>
            </select>
            <div class="form-text">Sélectionnez plusieurs cours en maintenant Ctrl (ou Cmd) enfoncé.</div>
        </div>
        <button type="submit" class="btn btn-success">Mettre à jour</button>
        <a href="<c:url value='/etudiants/list'/>" class="btn btn-secondary">Annuler</a>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>