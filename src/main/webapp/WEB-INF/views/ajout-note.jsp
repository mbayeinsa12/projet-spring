<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Note</title></head>
<body>
<h1>${titre}</h1>
<%--@elvariable id="note" type="aj"--%>
<form:form action="${action}" method="post" modelAttribute="note">
    <form:hidden path="id" />

    <label>Étudiant :</label>
    <form:select path="etudiant.id">
        <form:options items="${etudiants}" itemValue="id" itemLabel="nom" />
    </form:select><br>

    <label>Cours :</label>
    <form:select path="cours.id">
        <form:options items="${cours}" itemValue="id" itemLabel="nom" />
    </form:select><br>

    <label>Valeur :</label>
    <form:input path="valeur" /><br>

    <button type="submit">Enregistrer</button>
</form:form>
<a href="${pageContext.request.contextPath}/notes">Retour</a>
</body>
</html>
