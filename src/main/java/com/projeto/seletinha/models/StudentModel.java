package com.projeto.seletinha.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    private int registry;

    private String name;

    private int series;

    private int team;


    public StudentModel(String registry, String name, String series, String team) {
        this.registry = Integer.parseInt(registry);
        this.name = name;
        this.series = Integer.parseInt(series);
        this.team = Integer.parseInt(team);
    }
}
