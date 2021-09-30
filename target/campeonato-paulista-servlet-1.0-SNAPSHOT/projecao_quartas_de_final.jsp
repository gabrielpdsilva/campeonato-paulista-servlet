<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projeção das quartas de final</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Projeção das quartas de final</h1>

    <span>Clique no botão para exibir a projeção das quartas de final.</span>
    <form action="projecao_quartas_de_final" method="post">
        <input type="submit" value="Exibir quartas de final" id="exibir_quartas_de_final" name="button"/>
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
        <c:if test="${not empty todasAsQuartasDeFinal }">
            <h1>Quartas de Final</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Nome do primeiro time</th>
                    <th>Nome do segundo time</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="quartasDeFinal" items="${todasAsQuartasDeFinal }">
                    <tr>
                        <td>${quartasDeFinal.primeiroTime.nomeTime}</td>
                        <td>${quartasDeFinal.segundoTime.nomeTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>
