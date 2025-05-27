<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Filière</title></head>
<body>
<h1>${titre}</h1>
<%--@elvariable id="filiere" type="aj"--%>
<form:form action="${action}" method="post" modelAttribute="filiere">
    <form:hidden path="id" />
    <label>Nom :</label>
    <form:input path="nom" /><br>
    <button type="submit">Enregistrer</button>
</form:form>
<a href="${pageContext.request.contextPath}/filieres">Retour</a>
</body>
</html>
