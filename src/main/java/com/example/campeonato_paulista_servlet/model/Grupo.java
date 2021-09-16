package com.example.campeonato_paulista_servlet.model;

import java.util.ArrayList;

public class Grupo {

    public Grupo() {
        super();
    }

    private String grupo;
    private ArrayList<Time> times;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }
}
