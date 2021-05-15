
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Post</title>
</head>
<body>
<form:form action="post" method="POST" modelAttribute="post">
    <h3 class="form-signin-heading">Crear post</h3>
    <hr class="colorgraph"><br>

    <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
    <form:input path="nombre" id="nombre" type="text" class="form-control" />
    <form:input path="especialidad" type="text" id="especialidad" class="form-control"/>

    <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Create Post</button>
</form:form>
</body>
</html>
