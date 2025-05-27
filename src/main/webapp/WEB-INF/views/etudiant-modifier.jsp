<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un Étudiant</title>
</head>
<body>
<h1>Modifier un Étudiant</h1>

<%--@elvariable id="etudiant" type="aj"--%>
<form:form
        action="${pageContext.request.contextPath}/etudiants/modifier/${etudiant.id}"
        method="post"
        modelAttribute="etudiant">

    <form:hidden path="id" />

    <label for="prenom">Prénom:</label>
    <form:input path="prenom" id="prenom" /><br>

    <label for="nom">Nom:</label>
    <form:input path="nom" id="nom" /><br>

    <label for="email">Email:</label>
    <form:input path="email" id="email" type="email" /><br>

    <label for="telephone">Téléphone:</label>
    <form:input path="telephone" id="telephone" /><br>

    <label for="carteEtudiant">Carte Étudiant:</label>
    <form:input path="carteEtudiant" id="carteEtudiant" /><br>

    <label for="filiere">Filière:</label>
    <form:select path="filiere.id" id="filiere">
        <form:options items="${filieres}" itemValue="id" itemLabel="nom" />
    </form:select><br>

    <button type="submit">Enregistrer</button>
</form:form>

<a href="${pageContext.request.contextPath}/etudiants">Retour à la liste</a>
</body>
</html>
