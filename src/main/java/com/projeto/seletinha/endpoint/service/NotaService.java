package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.NotaModel;
import com.projeto.seletinha.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotaService {

    private final NotaRepository notaRepository;

    public String create(final NotaModel notaModel) {
        notaRepository.save(notaModel);
        return "SuccessFull";
    }

    public List<NotaModel> buscaNotas(int registry, int idGamer) {
        return notaRepository.findByRegistryStudentAndIdGamer(registry,idGamer);
    }

}
