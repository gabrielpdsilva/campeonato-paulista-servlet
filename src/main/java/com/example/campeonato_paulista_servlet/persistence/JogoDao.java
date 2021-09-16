package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Jogo;
import com.example.campeonato_paulista_servlet.model.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JogoDao implements IJogoDao {

    private Connection c;
    public JogoDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public ArrayList<Jogo> buscarJogosDaData(Date data) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT timesA.nome_time AS time_a, ");
        sql.append("timesB.nome_time AS time_b, ");
        sql.append("jo.gols_time_a AS gols_a, jo.gols_time_b AS gols_b, ");
        sql.append("jo.data AS data ");
        sql.append("FROM times timesA, times timesB, jogos jo ");
        sql.append("WHERE timesA.codigo_time = jo.codigo_time_a ");
        sql.append("AND timesB.codigo_time = jo.codigo_time_b ");
        sql.append("AND jo.data = ? ");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ps.setDate(1, new java.sql.Date(data.getTime()));
        ResultSet rs = ps.executeQuery();
        ArrayList<Jogo> jogos = new ArrayList<>();
        while(rs.next()) {
            Jogo jogo = new Jogo();
            Time timeA = new Time();
            Time timeB = new Time();
            timeA.setNomeTime(rs.getString("time_a"));
            timeB.setNomeTime(rs.getString("time_b"));
            jogo.setTimeA(timeA);
            jogo.setTimeB(timeB);
            jogo.setGolsTimeA(rs.getInt("gols_a"));
            jogo.setGolsTimeB(rs.getInt("gols_b"));
            jogo.setData(rs.getDate("data"));
            jogos.add(jogo);
        }
        rs.close();
        ps.close();
        return jogos;
    }
}
