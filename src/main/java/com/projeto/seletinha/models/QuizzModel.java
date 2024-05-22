package com.projeto.seletinha.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Quizz")
public class QuizzModel {

    @Id
    private int id;
    private String pergunta;
    private String a;
    private String b;
    private String c;
    private String d;
    private String tipo;
    private String resposta;
    private String justificativa;
    private String nivel;
}
