<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Cours</title></head>
<body>
<h1>${titre}</h1>
<%--@elvariable id="cours" type="aj"--%>
<form:form action="${action}" method="post" modelAttribute="cours">
  <form:hidden path="id" />
  <label>Nom :</label>
  <form:input path="nom" /><br>

  <label>Filière :</label>
  <form:select path="filiere.id">
    <form:options items="${filieres}" itemValue="id" itemLabel="nom" />
  </form:select><br>

  <button type="submit">Enregistrer</button>
</form:form>
<a href="${pageContext.request.contextPath}/cours">Retour</a>
</body>
</html>
