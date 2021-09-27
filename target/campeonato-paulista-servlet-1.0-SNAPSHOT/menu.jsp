<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
    <table border="1">
        <tr>
            <td><a href="dividir_times.jsp">Dividir times</a></td>
            <td><a href="gerar_rodadas.jsp">Gerar rodadas</a></td>
            <td><a href="exibir_grupos.jsp">Exibir grupos</a></td>
            <td><a href="buscar_jogos.jsp">Buscar jogos</a></td>
        </tr>

        <tr>
            <!--
            Fazer uma tela que, pelas datas dos jogos, seja possível inserir
            os resultados dos jogos, que fará um UPDATE na tabela jogos, que já
            terá os times e data, com os gols marcados por cada time.
            -->
            <td><a href="definir_resultados.jsp">Definir resultados</a></td>

            <!--
            Fazer uma tela de consulta com os 4 grupos e 4 Tabelas, que mostrem a
            saída (para cada Tabela) de uma UDF (User Defined FUNCTION), que receba
            o nome do grupo, valide-o e dê a seguinte saída:
            GRUPO (nome_time, num_jogos_disputados*, vitorias, empates, derrotas, gols_marcados,
            gols_sofridos, saldo_gols**,pontos***)
            -->
            <td><a href="detalhes_grupos.jsp">Detalhes dos grupos</a></td>

            <!--
            Deve-se fazer, para melhor visualização dos resultados, uma tela com a
            classificação geral, numa UDF (User Defined FUNCTION), que receba o nome
            do grupo, valide-o e dê a seguinte saída, para os 20 times do campeonato:

            CAMPEONATO (nome_time, num_jogos_disputados*, vitorias, empates, derrotas, gols_marcados,
            gols_sofridos, saldo_gols**,pontos***)
            -->
            <td><a href="classificacao_geral.jsp">Classificação geral</a></td>

            <!--
            Por fim, uma tela deverá ser criada para ver a projeção das quartas de final.
            As quartas de final serão disputadas entre o 1º e o 2º de cada grupo. Gerá-las a partir de UDF.
            -->
            <td><a href="projecao_quartas_de_final.jsp">Projeção das quartas de final</a></td>
        </tr>
    </table>
</div>
</body>
</html>