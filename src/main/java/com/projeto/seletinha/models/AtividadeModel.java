package com.projeto.seletinha.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Atividades")
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int serie;
    private int team;
    private String tipo;


    public AtividadeModel(String serie, String team, String tipo) {
        this.serie = Integer.parseInt(serie);
        this.team = Integer.parseInt(team);
        this.tipo = tipo;
    }


}
