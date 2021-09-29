package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.TimeDoCampeonato;
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

@WebServlet(name = "quartasDeFinalServlet", value = "/projecao_quartas_de_final")
public class QuartasDeFinalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ITimeDoCampeonatoDao tdcDao;

    public QuartasDeFinalServlet() {
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
        List<TimeDoCampeonato> timesDoGrupoA = new ArrayList<TimeDoCampeonato>();
        List<TimeDoCampeonato> timesDoGrupoB = new ArrayList<TimeDoCampeonato>();
        List<TimeDoCampeonato> timesDoGrupoC = new ArrayList<TimeDoCampeonato>();
        List<TimeDoCampeonato> timesDoGrupoD = new ArrayList<TimeDoCampeonato>();
        try {
            if (cmd.contains("Exibir quartas de final")) {
                Grupo grupo = new Grupo();
                grupo.setGrupo("A");
                timesDoGrupoA = tdcDao.buscarQuartasDeFinalDoGrupo(grupo);
                grupo.setGrupo("B");
                timesDoGrupoB = tdcDao.buscarQuartasDeFinalDoGrupo(grupo);
                grupo.setGrupo("C");
                timesDoGrupoC= tdcDao.buscarQuartasDeFinalDoGrupo(grupo);
                grupo.setGrupo("D");
                timesDoGrupoD = tdcDao.buscarQuartasDeFinalDoGrupo(grupo);
                saida = "Grupos encontrados com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            request.setAttribute("timesDoGrupoA", timesDoGrupoA);
            request.setAttribute("timesDoGrupoB", timesDoGrupoB);
            request.setAttribute("timesDoGrupoC", timesDoGrupoC);
            request.setAttribute("timesDoGrupoD", timesDoGrupoD);
            RequestDispatcher rd = request.getRequestDispatcher("projecao_quartas_de_final.jsp");
            rd.forward(request, response);
        }
    }

}