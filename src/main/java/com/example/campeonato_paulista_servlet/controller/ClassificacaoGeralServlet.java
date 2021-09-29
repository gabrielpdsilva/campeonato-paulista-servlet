package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.TimeDoCampeonato;
import com.example.campeonato_paulista_servlet.persistence.GrupoDao;
import com.example.campeonato_paulista_servlet.persistence.ITimeDoCampeonatoDao;
import com.example.campeonato_paulista_servlet.persistence.TimeDoCampeonatoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "exibirGruposServlet", value = "/classificacao_geral")
public class ClassificacaoGeralServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ITimeDoCampeonatoDao tdcDao;

    public ClassificacaoGeralServlet() {
        try {
            tdcDao = new TimeDoCampeonatoDao();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("button");
        String saida = "";
        String erro = "";
        System.out.println(cmd);
        List<TimeDoCampeonato> listaDeTimesDoCampeonato = new ArrayList<TimeDoCampeonato>();
        try {
            if(cmd.contains("Exibir classificacao")) {
                listaDeTimesDoCampeonato = tdcDao.buscarTodosOsTimesDoCampeonato();
                saida = "Busca realizada com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            request.setAttribute("campeonato", listaDeTimesDoCampeonato);
            RequestDispatcher rd = request.getRequestDispatcher("classificacao_geral.jsp");
            rd.forward(request, response);
        }
    }
}
