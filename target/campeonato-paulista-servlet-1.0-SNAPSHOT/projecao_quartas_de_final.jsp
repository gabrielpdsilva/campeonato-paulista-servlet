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
        <c:if test="${not empty timesDoGrupoA }">
            <h1>Grupo A</h1>
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
                <c:forEach var="time" items="${timesDoGrupoA }">
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
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesDoGrupoB }">
            <h1>Grupo B</h1>
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
                <c:forEach var="time" items="${timesDoGrupoB }">
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
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesDoGrupoC }">
            <h1>Grupo C</h1>
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
                <c:forEach var="time" items="${timesDoGrupoC }">
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
        </c:if>
    </div>

    <div>
        <c:if test="${not empty timesDoGrupoD }">
            <h1>Grupo D</h1>
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
                <c:forEach var="time" items="${timesDoGrupoD }">
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
        </c:if>
    </div>


</body>
</html>
