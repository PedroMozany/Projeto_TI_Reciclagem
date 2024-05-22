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
@Table(name = "AtivosDesc")
public class AtivosDescModel {

    @Id
    private int id;
    private String address;
    private String neighborhood;
    private String zone;
    private String disposalAssets;
}
