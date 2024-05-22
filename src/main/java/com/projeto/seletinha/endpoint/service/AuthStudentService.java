package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.StudentModel;
import com.projeto.seletinha.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthStudentService {

    private final StudentsRepository studentsRepository;

    public StudentModel searchId(final String registry) {

        try {
            Optional<StudentModel> student = studentsRepository.findById(Integer.valueOf(registry));
            return student.get();
        }catch (Exception e){
            return null;
        }
    }
}
