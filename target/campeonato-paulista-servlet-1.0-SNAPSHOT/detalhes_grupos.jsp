<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalhes dos grupos</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Detalhes dos grupos</h1>
    <span>Digite o nome de um grupo para ver seus respectivos detalhes.</span>
    <form action="detalhes_grupos" method="post">
        <input type="text" id="nome_grupo" name="nome_grupo">
        <input type="submit" value="Buscar grupo" id="buscar_grupo" name="button"/>
    </form>
</body>
</html>
