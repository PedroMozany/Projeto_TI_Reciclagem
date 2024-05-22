package com.projeto.seletinha.models;

import java.util.List;

public class DdosTeams {
     private String nameTeacher;
     private int registryTeacher;
     private List<TeamModel> listTurma;

    public DdosTeams(String nameTeacher, int registryTeacher, List<TeamModel> listTurma) {
        this.nameTeacher = nameTeacher;
        this.registryTeacher = registryTeacher;
        this.listTurma = listTurma;
    }

}
