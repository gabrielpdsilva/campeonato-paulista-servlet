package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.Time;
import com.example.campeonato_paulista_servlet.model.TimeDoCampeonato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDoCampeonatoDao implements ITimeDoCampeonatoDao {
    private Connection c;
    public TimeDoCampeonatoDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    // TODO implement using proper function
    @Override
    public List<TimeDoCampeonato> buscarTimesDoGrupo(Grupo grupo) throws SQLException {
        List<TimeDoCampeonato> listaTimesNoCampeonato = new ArrayList<TimeDoCampeonato>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ct.nome_time, ct.num_jogos_disputados , ct.vitorias, ");
        sql.append("ct.empates, ct.derrotas, ct.gols_marcados, ct.gols_sofridos, ");
        sql.append("ct.saldo_gols, ct.pontos ");
        sql.append("FROM campeonato_temp ct, times t, grupos g ");
        sql.append("WHERE ct.nome_time = t.nome_time ");
        sql.append("AND t.codigo_time = g.codigo_time ");
        sql.append("AND g.grupo = ? ");
        sql.append("ORDER BY ct.pontos DESC");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ps.setString(1, String.valueOf(grupo.getGrupo()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TimeDoCampeonato timeDoCampeonato = new TimeDoCampeonato();
            Time time = new Time();
            time.setNomeTime(rs.getString("nome_time"));
            timeDoCampeonato.setTime(time);
            timeDoCampeonato.setNumJogosDisputados(rs.getInt("num_jogos_disputados"));
            timeDoCampeonato.setVitorias(rs.getInt("vitorias"));
            timeDoCampeonato.setEmpates(rs.getInt("empates"));
            timeDoCampeonato.setDerrotas(rs.getInt("derrotas"));
            timeDoCampeonato.setGolsMarcados(rs.getInt("gols_marcados"));
            timeDoCampeonato.setGolsSofridos(rs.getInt("gols_sofridos"));
            timeDoCampeonato.setSaldoGols(rs.getInt("saldo_gols"));
            timeDoCampeonato.setPontos(rs.getInt("pontos"));
            listaTimesNoCampeonato.add(timeDoCampeonato);
        }
        rs.close();
        ps.close();
        return listaTimesNoCampeonato;
    }

    // TODO implement using function, such as sp_buscar_campeonato()
    @Override
    public List<TimeDoCampeonato> buscarTodosOsTimesDoCampeonato() throws SQLException {
        List<TimeDoCampeonato> listaTimesNoCampeonato = new ArrayList<TimeDoCampeonato>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT nome_time, num_jogos_disputados, vitorias, empates, ");
        sql.append("derrotas, gols_marcados, gols_sofridos, ");
        sql.append("saldo_gols, pontos FROM campeonato_temp");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TimeDoCampeonato timeDoCampeonato = new TimeDoCampeonato();
            Time time = new Time();
            time.setNomeTime(rs.getString("nome_time"));
            timeDoCampeonato.setTime(time);
            timeDoCampeonato.setNumJogosDisputados(rs.getInt("num_jogos_disputados"));
            timeDoCampeonato.setVitorias(rs.getInt("vitorias"));
            timeDoCampeonato.setEmpates(rs.getInt("empates"));
            timeDoCampeonato.setDerrotas(rs.getInt("derrotas"));
            timeDoCampeonato.setGolsMarcados(rs.getInt("gols_marcados"));
            timeDoCampeonato.setGolsSofridos(rs.getInt("gols_sofridos"));
            timeDoCampeonato.setSaldoGols(rs.getInt("saldo_gols"));
            timeDoCampeonato.setPontos(rs.getInt("pontos"));
            listaTimesNoCampeonato.add(timeDoCampeonato);
        }
        rs.close();
        ps.close();
        return listaTimesNoCampeonato;
    }

    // TODO implement using proper function
    @Override
    public List<TimeDoCampeonato> buscarQuartasDeFinalDoGrupo(Grupo grupo) throws SQLException {
        List<TimeDoCampeonato> listaTimesNoCampeonato = new ArrayList<TimeDoCampeonato>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT TOP 2 ");
        sql.append("ct.nome_time, ct.num_jogos_disputados , ct.vitorias, ");
        sql.append("ct.empates, ct.derrotas, ct.gols_marcados, ct.gols_sofridos, ");
        sql.append("ct.saldo_gols, ct.pontos ");
        sql.append("FROM campeonato_temp ct, times t, grupos g ");
        sql.append("WHERE ct.nome_time = t.nome_time ");
        sql.append("AND t.codigo_time = g.codigo_time ");
        sql.append("AND g.grupo = ? ");
        sql.append("ORDER BY ct.pontos DESC");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ps.setString(1, String.valueOf(grupo.getGrupo()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TimeDoCampeonato timeDoCampeonato = new TimeDoCampeonato();
            Time time = new Time();
            time.setNomeTime(rs.getString("nome_time"));
            timeDoCampeonato.setTime(time);
            timeDoCampeonato.setNumJogosDisputados(rs.getInt("num_jogos_disputados"));
            timeDoCampeonato.setVitorias(rs.getInt("vitorias"));
            timeDoCampeonato.setEmpates(rs.getInt("empates"));
            timeDoCampeonato.setDerrotas(rs.getInt("derrotas"));
            timeDoCampeonato.setGolsMarcados(rs.getInt("gols_marcados"));
            timeDoCampeonato.setGolsSofridos(rs.getInt("gols_sofridos"));
            timeDoCampeonato.setSaldoGols(rs.getInt("saldo_gols"));
            timeDoCampeonato.setPontos(rs.getInt("pontos"));
            listaTimesNoCampeonato.add(timeDoCampeonato);
        }
        rs.close();
        ps.close();
        return listaTimesNoCampeonato;
    }
}
