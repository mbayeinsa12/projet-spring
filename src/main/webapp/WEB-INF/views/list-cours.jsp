<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des Cours</title></head>
<body>
<h1>Cours</h1>
<a href="${pageContext.request.contextPath}/cours/ajouter">Ajouter un cours</a>
<table border="1">
    <tr><th>Nom</th><th>Filière</th><th>Actions</th></tr>
    <c:forEach var="cours" items="${coursList}">
        <tr>
            <td>${cours.nom}</td>
            <td>${cours.filiere.nom}</td>
            <td>
                <a href="${pageContext.request.contextPath}/cours/modifier/${cours.id}">Modifier</a> |
                <a href="${pageContext.request.contextPath}/cours/supprimer/${cours.id}" onclick="return confirm('Supprimer ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
