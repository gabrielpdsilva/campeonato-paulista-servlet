package com.example.campeonato_paulista_servlet.persistence;

import com.example.campeonato_paulista_servlet.model.Grupo;

import java.sql.SQLException;

public interface IGrupoDao {
    Grupo buscarGrupo(Grupo grupo) throws SQLException;
    boolean gerarRodadasAleatoriamente() throws SQLException;
}
