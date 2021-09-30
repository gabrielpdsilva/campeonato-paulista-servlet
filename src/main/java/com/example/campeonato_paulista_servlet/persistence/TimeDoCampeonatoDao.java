package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.QuartaDeFinal;
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

    @Override
    public List<TimeDoCampeonato> buscarTimesDoGrupo(Grupo grupo) throws SQLException {
        List<TimeDoCampeonato> listaTimesNoCampeonato = new ArrayList<TimeDoCampeonato>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT nome_time, num_jogos AS num_jogos_disputados , vitoria AS vitorias, ");
        sql.append("empate AS empates, derrota AS derrotas, gols_marcados, gols_sofridos, ");
        sql.append("saldo_gols, pontos ");
        sql.append("FROM fn_grupos_paulistao(?) ORDER BY pontos DESC, vitoria DESC, gols_marcados DESC, saldo_gols DESC");
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

    @Override
    public List<TimeDoCampeonato> buscarTodosOsTimesDoCampeonato() throws SQLException {
        List<TimeDoCampeonato> listaTimesNoCampeonato = new ArrayList<TimeDoCampeonato>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT nome_time, num_jogos AS num_jogos_disputados , vitoria AS vitorias, ");
        sql.append("empate AS empates, derrota AS derrotas, gols_marcados, gols_sofridos, saldo_gols, pontos ");
        sql.append("FROM fn_classificação_geral() ");
        sql.append("Order by pontos DESC, vitoria DESC, gols_marcados DESC, saldo_gols DESC");
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

    @Override
    public List<QuartaDeFinal> buscarQuartasDeFinal() throws SQLException {
        List<QuartaDeFinal> listaTimesNoCampeonato = new ArrayList<QuartaDeFinal>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT classificado_1, classificado_2 FROM fn_quartas_final()");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Time primeiroTime = new Time();
            Time segundoTime = new Time();
            primeiroTime.setNomeTime(rs.getString("classificado_1"));
            segundoTime.setNomeTime(rs.getString("classificado_2"));
            QuartaDeFinal quartaDeFinal = new QuartaDeFinal();
            quartaDeFinal.setPrimeiroTime(primeiroTime);
            quartaDeFinal.setSegundoTime(segundoTime);
            listaTimesNoCampeonato.add(quartaDeFinal);
        }
        rs.close();
        ps.close();
        return listaTimesNoCampeonato;
    }
}
