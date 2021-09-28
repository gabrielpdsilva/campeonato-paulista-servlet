package com.example.campeonato_paulista_servlet.controller;
import com.example.campeonato_paulista_servlet.model.Jogo;
import com.example.campeonato_paulista_servlet.persistence.GrupoDao;
import com.example.campeonato_paulista_servlet.persistence.IJogoDao;
import com.example.campeonato_paulista_servlet.persistence.JogoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "definirResultadosDosJogosServlet", value = "/definir_resultados")
public class DefinirResultadosDosJogosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IJogoDao jDao;

    public DefinirResultadosDosJogosServlet() {
        try {
            jDao = new JogoDao();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private Date validarData(HttpServletRequest request) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada;
        try {
            String dataEmString = request.getParameter("data_jogo").trim();
            dataFormatada = format.parse(dataEmString);
        } catch (ParseException e) {
            e.printStackTrace();
            dataFormatada = new Date();
        }
        return dataFormatada;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("button");
        System.out.println(cmd);
        String saida = "";
        String erro = "";
        Date data = validarData(request);
        ArrayList<Jogo> listaDeJogos = new ArrayList<Jogo>();

        // Botao buscar jogos
        if (cmd.contains("Buscar jogos")) {
            System.out.println("Clicou em buscar jogos");
            try {
                listaDeJogos = jDao.buscarJogosDaData(data);
                if(listaDeJogos.isEmpty()) {
                    saida = "Não haverão jogos na data escolhida.";
                } else {
                    saida = "Busca realizada com sucesso!";
                }
            } catch (SQLException e) {
                erro = e.getMessage();
                e.printStackTrace();
            } finally {
                request.setAttribute("saida", saida);
                request.setAttribute("erro", erro);
                request.setAttribute("listaDeJogos", listaDeJogos);
                RequestDispatcher rd = request.getRequestDispatcher("definir_resultados.jsp");
                rd.forward(request, response);
            }
        }

        // Botao definir resultados
        if (cmd.contains("Definir resultados")) {
            System.out.println("Clicou em definir resultados");
            try {
                jDao.definirResultadosDaData(data);
                listaDeJogos = jDao.buscarJogosDaData(data);
                if(listaDeJogos.isEmpty()) {
                    saida = "Não haverão jogos na data escolhida.";
                } else {
                    saida = "Resultados definidos com sucesso!";
                }
            } catch (SQLException e) {
                erro = e.getMessage();
                e.printStackTrace();
            } finally {
                request.setAttribute("saida", saida);
                request.setAttribute("erro", erro);
                request.setAttribute("listaDeJogos", listaDeJogos);
                RequestDispatcher rd = request.getRequestDispatcher("definir_resultados.jsp");
                rd.forward(request, response);
            }
        }

    }
}
