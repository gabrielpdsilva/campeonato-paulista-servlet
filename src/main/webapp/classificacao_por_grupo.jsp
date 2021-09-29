<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classificação por grupo</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Classificação por grupo</h1>
<span>Selecione um grupo e clique no botão para visualizar seus respectivos detalhes.</span>
<form action="classificacao_por_grupo" method="post">
    <div>
        <input type="radio" name="grupo" value="a" id="a">A
        <input type="radio" name="grupo" value="b" id="b">B
        <input type="radio" name="grupo" value="c" id="c">C
        <input type="radio" name="grupo" value="d" id="d">D
    </div>
    <br/>
    <input type="submit" value="Buscar grupo" id="buscar_grupo" name="button"/>
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
        <h1>Grupo</h1>
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
