<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Modifier une Note</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h1 class="mb-4">Modifier une Note</h1>
  <form:form action="${pageContext.request.contextPath}/notes/update" method="post" modelAttribute="note">
    <form:hidden path="id"/>
    <div class="mb-3">
      <label for="valeur" class="form-label">Valeur:</label>
      <form:input type="number" step="0.01" path="valeur" class="form-control" id="valeur" required="true"/>
    </div>
    <div class="mb-3">
      <label for="etudiant" class="form-label">Étudiant:</label>
      <select class="form-select" id="etudiant" name="etudiantId" required>
        <option value="">-- Sélectionnez un Étudiant --</option>
        <c:forEach var="etudiantOption" items="${etudiants}">
          <option value="${etudiantOption.id}"
                  <c:if test="${note.etudiant.id == etudiantOption.id}">selected</c:if>
          >${etudiantOption.nom} ${etudiantOption.prenom}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label for="cours" class="form-label">Cours:</label>
      <select class="form-select" id="cours" name="coursId" required>
        <option value="">-- Sélectionnez un Cours --</option>
        <c:forEach var="coursOption" items="${coursList}">
          <option value="${coursOption.id}"
                  <c:if test="${note.cours.id == coursOption.id}">selected</c:if>
          >${coursOption.titre}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-success">Mettre à jour</button>
    <a href="<c:url value='/notes/list'/>" class="btn btn-secondary">Annuler</a>
  </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>