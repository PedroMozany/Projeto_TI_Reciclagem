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
@Table(name = "Notas")
public class NotaModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int registryStudent;
    private int idGamer;
    private double value;

    public NotaModel(String registryStudent, String idGamer, String value) {
        this.registryStudent = Integer.parseInt(registryStudent);
        this.idGamer = Integer.parseInt(idGamer);
        this.value = Double.parseDouble(value);
    }
}
