package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.AtivosDescModel;
import com.projeto.seletinha.repository.AtivosDescarteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AtivosDescService {


    private final AtivosDescarteRepository ativosDescarteRepository;




    public List<AtivosDescModel> searchZone(final String zone) {
        List<AtivosDescModel> student =  ativosDescarteRepository.findByZone(zone);
        return student;
    }

    public List<AtivosDescModel> searchAll() {
        return ativosDescarteRepository.findAll();
    }
}
