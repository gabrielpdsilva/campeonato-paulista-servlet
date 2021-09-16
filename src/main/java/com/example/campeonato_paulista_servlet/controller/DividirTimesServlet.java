package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.persistence.ITimeDao;
import com.example.campeonato_paulista_servlet.persistence.TimeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "dividirTimesServlet", value = "/dividir_times")
public class DividirTimesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ITimeDao tDao;

    public DividirTimesServlet() {
        try {
            tDao = new TimeDao();
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
            if (cmd.contains("Dividir times")) {
                tDao.dividirTimesAleatoriamente();
                saida = "Times divididos com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            RequestDispatcher rd = request.getRequestDispatcher("dividir_times.jsp");
            rd.forward(request, response);
        }
    }

}