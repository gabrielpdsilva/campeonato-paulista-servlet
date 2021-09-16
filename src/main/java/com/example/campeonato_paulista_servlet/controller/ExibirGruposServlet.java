package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.persistence.GrupoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "exibirGruposServlet", value = "/exibir_grupos")
public class ExibirGruposServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private GrupoDao gDao;

    public ExibirGruposServlet() {
        try {
            gDao = new GrupoDao();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private Grupo buscarPeloGrupoDaLetra(String letra) throws SQLException {
        Grupo grupo = new Grupo();
        grupo.setGrupo(letra);
        grupo = gDao.buscarGrupo(grupo);
        return grupo;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("button");
        String saida = "";
        String erro = "";
        Grupo grupoA = new Grupo();
        Grupo grupoB = new Grupo();
        Grupo grupoC = new Grupo();
        Grupo grupoD = new Grupo();
        try {
            if (cmd.contains("Exibir grupos")) {
                grupoA = buscarPeloGrupoDaLetra("A");
                grupoB = buscarPeloGrupoDaLetra("B");
                grupoC = buscarPeloGrupoDaLetra("C");
                grupoD = buscarPeloGrupoDaLetra("D");
                saida = "Busca realizada com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            request.setAttribute("timesGrupoA", grupoA.getTimes());
            request.setAttribute("timesGrupoB", grupoB.getTimes());
            request.setAttribute("timesGrupoC", grupoC.getTimes());
            request.setAttribute("timesGrupoD", grupoD.getTimes());
            RequestDispatcher rd = request.getRequestDispatcher("exibir_grupos.jsp");
            rd.forward(request, response);
        }
    }

}