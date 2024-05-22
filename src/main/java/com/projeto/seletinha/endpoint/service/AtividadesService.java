package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.AtividadeModel;
import com.projeto.seletinha.models.DdosAtividades;
import com.projeto.seletinha.models.StudentModel;
import com.projeto.seletinha.repository.AtividadeRepository;
import com.projeto.seletinha.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AtividadesService {

    private final AtividadeRepository atividadeRepository;

    private final StudentsRepository studentsRepository;


    public String create(final AtividadeModel atividadeModel) {
        atividadeRepository.save(atividadeModel);
        return "SuccessFull";
    }


    public DdosAtividades localizar(int resgistry) {
        Optional<StudentModel> student = studentsRepository.findById(resgistry);
        StudentModel  studentModel = student.get();
        Optional<AtividadeModel> atividade = atividadeRepository.findBySerieAndTeam(studentModel.getSeries(),studentModel.getTeam());
        AtividadeModel atividadeModel = atividade.get();
        return new DdosAtividades(studentModel.getName(), studentModel.getRegistry(), atividadeModel.getTipo());
    }


}
