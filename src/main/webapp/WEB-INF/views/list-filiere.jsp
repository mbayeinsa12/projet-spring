<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des Filières</title></head>
<body>
<h1>Filières</h1>
<a href="${pageContext.request.contextPath}/filieres/ajouter">Ajouter une filière</a>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Nom</th>
        <th>Département</th>
        <th>Prénom Responsable</th>
        <th>Nom Responsable</th>
        <th>Description</th>
        <th>Étudiants</th>
        <th>Cours</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="filiere" items="${filieres}">
        <tr>
            <td>${filiere.id}</td>
            <td>${filiere.code}</td>
            <td>${filiere.nom}</td>
            <td>${filiere.departement}</td>
            <td>${filiere.prenomResponsable}</td>
            <td>${filiere.nomResponsable}</td>
            <td>${filiere.description}</td>
            <td>${filiere.etudiants.size()}</td>
            <td>${filiere.cours.size()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/filieres/modifier/${filiere.id}">Modifier</a> |
                <a href="${pageContext.request.contextPath}/filieres/supprimer/${filiere.id}" onclick="return confirm('Supprimer ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
