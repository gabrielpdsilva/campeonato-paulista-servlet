<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classificação por grupo</title>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <h1>Classificação por grupo</h1>
    <span>Digite o nome de um grupo para ver seus respectivos detalhes.</span>
    <form action="classificacao_por_grupo" method="post">
        <input type="text" id="nome_grupo" name="nome_grupo">
        <input type="submit" value="Buscar grupo" id="buscar_grupo" name="button"/>
    </form>

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
                
                </tbody>
            </table>

    </div>
</body>
</html>
