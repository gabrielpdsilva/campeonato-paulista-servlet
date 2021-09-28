package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;

import java.sql.SQLException;
import java.util.ArrayList;

public class TimeDoCampeonatoDao implements ITimeDoCampeonatoDao {

    @Override
    public ArrayList<TimeDoCampeonatoDao> buscarTimesDoGrupo(Grupo grupo) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<TimeDoCampeonatoDao> buscarTodosOsTimesDoCampeonato() throws SQLException {
        return null;
    }
}
