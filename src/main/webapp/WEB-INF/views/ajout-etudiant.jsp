<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajouter un Étudiant</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<h1>Ajouter un Étudiant</h1>

  <div class="table-container">
    <!-- Formulaire Spring avec modelAttribute="etudiant" -->
    <form:form action="/etudiants/save" method="post" modelAttribute="etudiant">
  </div>

  <div class="table-container">
      <label for="prenom">Prénom:</label>
      <form:input path="prenom" id="prenom" /><br>
  </div>

  <div class="table-container">
      <label for="nom">Nom:</label>
      <form:input path="nom" id="nom" /><br>
  </div class="table-container">

<div class="table-container">
      <label for="email">Email:</label>
      <form:input path="email" id="email" type="email" /><br>
  </div>

<div class="table-container">
  <label for="telephone">Téléphone:</label>
  <form:input path="telephone" id="telephone" type="number" /><br>
  </div>

<div class="table-container">
  <label for="carteEtudiant">Carte Étudiant:</label>
  <form:input path="carteEtudiant" id="carteEtudiant" /><br>
</div>

<div class="table-container">
  <label for="filiere">Filière:</label>
    <form:select path="filiere.id" id="filiere">
      <form:options items="${filieres}" itemValue="id" itemLabel="nom" />
    </form:select><br>
  </div>

<td>
  <button type="submit" class="btn btn-primary">Enregistrer</button>
</td>
</form:form>

<a href="/etudiants" class="btn btn-primary">Retour à la liste</a>
</body>
</html>
