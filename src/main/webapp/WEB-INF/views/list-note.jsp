<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des Notes</title></head>
<body>
<h1>Notes</h1>
<a href="${pageContext.request.contextPath}/notes/ajouter">Ajouter une note</a>
<table border="1">
    <tr><th>Étudiant</th><th>Cours</th><th>Note</th><th>Actions</th></tr>
    <c:forEach var="note" items="${notes}">
        <tr>
            <td>${note.etudiant.prenom} ${note.etudiant.nom}</td>
            <td>${note.cours.nom}</td>
            <td>${note.valeur}</td>
            <td>
                <a href="${pageContext.request.contextPath}/notes/modifier/${note.id}">Modifier</a> |
                <a href="${pageContext.request.contextPath}/notes/supprimer/${note.id}" onclick="return confirm('Supprimer ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
