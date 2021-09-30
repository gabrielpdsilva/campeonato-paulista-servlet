package com.example.campeonato_paulista_servlet.controller;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.TimeDoCampeonato;
import com.example.campeonato_paulista_servlet.persistence.GrupoDao;
import com.example.campeonato_paulista_servlet.persistence.IGrupoDao;
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

@WebServlet(name = "classificacaoPorGrupoServlet", value = "/classificacao_por_grupo")
public class ClassificacaoPorGrupoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ITimeDoCampeonatoDao tdcDao;

    public ClassificacaoPorGrupoServlet() {
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
        List<TimeDoCampeonato> listaDeTimesDoGrupo = new ArrayList<TimeDoCampeonato>();
        List<TimeDoCampeonato> listaDeTodosOsTimes = new ArrayList<TimeDoCampeonato>();
        List<TimeDoCampeonato> listaPioresTimesDoCampeonato = new ArrayList<TimeDoCampeonato>();
        try {
            String letraDoGrupo = request.getParameter("grupo").toUpperCase();
            if (cmd.contains("Buscar grupo")) {
                Grupo grupo = new Grupo();
                grupo.setGrupo(letraDoGrupo);
                listaDeTimesDoGrupo = tdcDao.buscarTimesDoGrupo(grupo);
                listaDeTodosOsTimes = tdcDao.buscarTodosOsTimesDoCampeonato();
                listaPioresTimesDoCampeonato.add(listaDeTodosOsTimes.get(14));
                listaPioresTimesDoCampeonato.add(listaDeTodosOsTimes.get(15));
                saida = "Grupo encontrado com sucesso!";
            }
        } catch (SQLException e) {
            erro = e.getMessage();
            e.printStackTrace();
        } finally {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            request.setAttribute("listaDeTimesDoGrupo", listaDeTimesDoGrupo);
            request.setAttribute("listaPioresTimesDoCampeonato", listaPioresTimesDoCampeonato);
            RequestDispatcher rd = request.getRequestDispatcher("classificacao_por_grupo.jsp");
            rd.forward(request, response);
        }
    }

}
