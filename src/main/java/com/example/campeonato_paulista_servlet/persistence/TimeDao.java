package com.example.campeonato_paulista_servlet.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class TimeDao implements ITimeDao {
    private Connection c;
    public TimeDao() throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        c = gDao.getConnection();
    }

    @Override
    public boolean dividirTimesAleatoriamente() throws SQLException {
        String sql = "{CALL sp_dividir_time_grupos(?)}";
        CallableStatement cs = c.prepareCall(sql);
        cs.registerOutParameter(1, Types.BIT);
        cs.execute();
        boolean saida = cs.getBoolean(1);
        cs.close();
        if(saida) {
            return true;
        }
        throw new SQLException("Ocorreu um erro ao tentar dividir os times em grupos.");
    }
}
