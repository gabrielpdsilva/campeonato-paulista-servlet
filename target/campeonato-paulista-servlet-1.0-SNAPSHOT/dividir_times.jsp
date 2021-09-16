<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dividir times</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Dividir times</h1>
    <span>Clique no botão para dividir os times.</span>
    <form action="dividir_times" method="post">
        <input type="submit" value="Dividir times" id="dividir_times" name="button"/>
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