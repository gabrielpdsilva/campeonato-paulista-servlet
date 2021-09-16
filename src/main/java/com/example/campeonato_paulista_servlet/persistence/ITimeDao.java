package com.example.campeonato_paulista_servlet.persistence;

import java.sql.SQLException;

public interface ITimeDao {
    boolean dividirTimesAleatoriamente() throws SQLException;
}
