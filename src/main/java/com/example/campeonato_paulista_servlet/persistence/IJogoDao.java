package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Jogo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface IJogoDao {
    ArrayList<Jogo> buscarJogosDaData(Date data) throws SQLException;
    void definirResultadosDaData(Date data) throws SQLException;
}
