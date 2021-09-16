<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exibir grupos</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Exibir grupos</h1>
    <span>Clique no botão para exibir os grupos existentes.</span>
    <form action="exibir_grupos" method="post">
        <input type="submit" value="Exibir grupos" id="exibir_grupos" name="button"/>
    </form>


    <div>
        <c:if test="${not empty saida }">
            <p><c:out value="${saida }" /></p>
        </c:if>

        <c:if test="${not empty erro }">
            <h2 style="color: #ff0000"><c:out value="${erro }" /></h2>
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesGrupoA }">
            <h1>Grupo A</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="time" items="${timesGrupoA }">
                    <tr>
                        <td>${time.codigoTime}</td>
                        <td>${time.nomeTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>


    <div>
        <c:if test="${not empty timesGrupoB }">
            <h1>Grupo B</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="time" items="${timesGrupoB }">
                    <tr>
                        <td>${time.codigoTime}</td>
                        <td>${time.nomeTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesGrupoC }">
            <h1>Grupo C</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="time" items="${timesGrupoC }">
                    <tr>
                        <td>${time.codigoTime}</td>
                        <td>${time.nomeTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesGrupoD }">
            <h1>Grupo D</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="time" items="${timesGrupoD }">
                    <tr>
                        <td>${time.codigoTime}</td>
                        <td>${time.nomeTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>