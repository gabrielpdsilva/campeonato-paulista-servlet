package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.persistence.GrupoDao;
import com.example.campeonato_paulista_servlet.persistence.IGrupoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "gerarRodadasServlet", value = "/gerar_rodadas")
public class GerarRodadasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IGrupoDao gDao;

    public GerarRodadasServlet() {
        try {
            gDao = new GrupoDao();
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
        try {
            if (cmd.contains("Gerar rodadas")) {
                gDao.gerarRodadasAleatoriamente();
                saida = "Rodadas geradas com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            RequestDispatcher rd = request.getRequestDispatcher("gerar_rodadas.jsp");
            rd.forward(request, response);
        }
    }

}