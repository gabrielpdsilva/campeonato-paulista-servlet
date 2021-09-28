package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.Jogo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface ITimeDoCampeonatoDao {
    ArrayList<TimeDoCampeonatoDao> buscarTimesDoGrupo(Grupo grupo) throws SQLException;
    ArrayList<TimeDoCampeonatoDao> buscarTodosOsTimesDoCampeonato() throws SQLException;
}
