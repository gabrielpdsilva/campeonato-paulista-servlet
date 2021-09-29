package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;
import com.example.campeonato_paulista_servlet.model.Jogo;
import com.example.campeonato_paulista_servlet.model.TimeDoCampeonato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ITimeDoCampeonatoDao {
    List<TimeDoCampeonato> buscarTimesDoGrupo(Grupo grupo) throws SQLException;
    List<TimeDoCampeonato> buscarTodosOsTimesDoCampeonato() throws SQLException;
}
