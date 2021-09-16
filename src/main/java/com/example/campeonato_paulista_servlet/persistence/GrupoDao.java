package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.Time;

import java.sql.*;
import java.util.ArrayList;

public class GrupoDao implements IGrupoDao {

    private Connection c;
    public GrupoDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public Grupo buscarGrupo(Grupo grupo) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT t.codigo_time AS codigo_time, ");
        sql.append("t.nome_time AS nome_time ");
        sql.append("FROM times t, grupos g ");
        sql.append("WHERE t.codigo_time = g.codigo_time AND g.grupo = ?");
        PreparedStatement ps = c.prepareStatement(sql.toString());
        ps.setString(1, String.valueOf(grupo.getGrupo()));
        ResultSet rs = ps.executeQuery();
        ArrayList<Time> times = new ArrayList<>();
        while(rs.next()) {
            Time time = new Time();
            time.setCodigoTime(rs.getInt("codigo_time"));
            time.setNomeTime(rs.getString("nome_time"));
            times.add(time);
        }
        rs.close();
        ps.close();
        grupo.setTimes(times);
        return grupo;
    }

    @Override
    public boolean gerarRodadasAleatoriamente() throws SQLException {
        String sql = "{CALL sp_gerar_rodadas_jogos(?)}";
        CallableStatement cs = c.prepareCall(sql);
        cs.registerOutParameter(1, Types.BIT);
        cs.execute();
        boolean saida = cs.getBoolean(1);
        cs.close();
        if(saida) {
            return true;
        }
        throw new SQLException("Ocorreu um erro ao tentar formar as rodadas dos jogos.");
    }
}
