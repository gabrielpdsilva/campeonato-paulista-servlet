<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gerar rodadas</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Gerar rodadas</h1>
    <span>Clique no botão para gerar as rodadas.</span>
    <form action="gerar_rodadas" method="post">
        <input type="submit" value="Gerar rodadas" id="gerar_rodadas" name="button"/>
    </form>
    <div>
        <c:if test="${not empty saida }">
            <p><c:out value="${saida }" /></p>
        </c:if>

        <c:if test="${not empty erro }">
            <h2 style="color: #ff0000"><c:out value="${erro }" /></h2>
        </c:if>
    </div>
</body>
</html>