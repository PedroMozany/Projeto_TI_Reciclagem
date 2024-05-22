package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.QuizzModel;
import com.projeto.seletinha.repository.QuizzRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuizzService {

    private final QuizzRepository quizzRepository;

    public List<QuizzModel> questions(String nivel, String tipo, int amount) {
        quizzRepository.findByNivelAndTipo(nivel, tipo);
        return quizzRepository.findByNivelAndTipo(nivel, tipo).stream().limit(amount).collect(Collectors.toList());
    }


}
