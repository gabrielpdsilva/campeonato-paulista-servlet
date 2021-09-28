<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Definir resultados</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Definir resultados</h1>
    <span>Selecione uma data e defina o resultado dos jogos do respectivo período.</span>
    <form action="definir_resultados" method="post">
        <input type="date" id="data_jogo" name="data_jogo">
        <input type="submit" value="Buscar jogos" id="buscar_jogos" name="button"/>

        <c:if test="${not empty listaDeJogos }">
            <input type="submit" value="Definir resultados" id="definir_resultados" name="button"/>
        </c:if>
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
        <c:if test="${not empty listaDeJogos }">
            <table border = 1>
                <thead>
                <tr>
                    <th>Primeiro time</th>
                    <th>Segundo time</th>
                    <th>Gols do primeiro time</th>
                    <th>Gols do segundo time</th>
                    <th>Data</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="jogo" items="${listaDeJogos }">
                    <tr>
                        <td>${jogo.timeA.nomeTime}</td>
                        <td>${jogo.timeB.nomeTime}</td>
                        <td>${jogo.golsTimeA}</td>
                        <td>${jogo.golsTimeB}</td>
                        <td>${jogo.data}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>
