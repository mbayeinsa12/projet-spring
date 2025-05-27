<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Ajouter un Cours</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>

            <body>
                <div class="container mt-4">
                    <h1 class="mb-4">Ajouter un Cours</h1>
                    <form:form action="${pageContext.request.contextPath}/cours/save" method="post" modelAttribute="cours">
                        <div class="mb-3">
                            <label for="titre" class="form-label">Titre:</label>
                            <form:input path="titre" class="form-control" id="titre" required="true" />
                        </div>
                        <div class="mb-3">
                            <label for="credit" class="form-label">Crédit:</label>
                            <form:input type="number" path="credit" class="form-control" id="credit" required="true" />
                        </div>
                        <button type="submit" class="btn btn-success">Enregistrer</button>
                        <a href="<c:url value='/cours/list'/>" class="btn btn-secondary">Annuler</a>
                    </form:form>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>