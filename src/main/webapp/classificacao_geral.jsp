<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classificação geral</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Classificação geral</h1>
    <span>Clique no botão para exibir a classificação geral.</span>
    <form action="classificacao_geral" method="post">
        <input type="submit" value="Exibir classificacao" id="exibir_classificacao" name="button"/>
    </form>

    <div>
        <c:if test="${not empty saida }">
            <p><c:out value="${saida }" /></p>
        </c:if>

        <c:if test="${not empty erro }">
            <h2 style="color: #ff0000"><c:out value="${erro }" /></h2>
        </c:if>
    </div>

    <c:if test="${not empty campeonato }">
        <div>
            <h1>Campeonato</h1>
            <table border = 1>
                <thead>
                <tr>
                    <th>Nome do time</th>
                    <th>Numero de jogos</th>
                    <th>Vitorias</th>
                    <th>Empates</th>
                    <th>Derrotas</th>
                    <th>Gols marcados</th>
                    <th>Gols sofridos</th>
                    <th>Saldo de gols</th>
                    <th>Pontos</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="time" items="${campeonato }">
                    <tr>
                        <td>${time.time.nomeTime}</td>
                        <td>${time.numJogosDisputados}</td>
                        <td>${time.vitorias}</td>
                        <td>${time.empates}</td>
                        <td>${time.derrotas}</td>
                        <td>${time.golsMarcados}</td>
                        <td>${time.golsSofridos}</td>
                        <td>${time.saldoGols}</td>
                        <td>${time.pontos}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

</body>
</html>
