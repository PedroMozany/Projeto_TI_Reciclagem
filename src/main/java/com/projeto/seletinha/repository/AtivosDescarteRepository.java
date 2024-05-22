package com.projeto.seletinha.repository;

import com.projeto.seletinha.models.AtivosDescModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtivosDescarteRepository extends JpaRepository<AtivosDescModel, Integer> {

    List<AtivosDescModel> findAll();
    List<AtivosDescModel> findByZone(String zone);

}
