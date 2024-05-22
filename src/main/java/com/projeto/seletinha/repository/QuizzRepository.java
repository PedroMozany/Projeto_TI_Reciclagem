package com.projeto.seletinha.repository;

import com.projeto.seletinha.models.QuizzModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface QuizzRepository extends JpaRepository<QuizzModel, Integer> {
    List<QuizzModel> findByNivelAndTipo(String nivel, String tipo);
}
