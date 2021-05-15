<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
    <h1>Hola gente</h1>
    <c:if test="${not empty posts}">
        <h2>Columns</h2>
        <ul>
            <c:forEach var="post" items="${posts}">
               <h2>${post.nombre}</h2>
                <h3>${post.especialidad}</h3>
                <br>

            </c:forEach>
        </ul>

    </c:if>
</body>
</html>
