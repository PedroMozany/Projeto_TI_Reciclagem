package com.projeto.seletinha.endpoint.service;

import com.projeto.seletinha.models.DdosTeams;
import com.projeto.seletinha.models.StudentModel;
import com.projeto.seletinha.models.TeachersModel;
import com.projeto.seletinha.models.TeamModel;
import com.projeto.seletinha.repository.StudentsRepository;
import com.projeto.seletinha.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentsRepository studentsRepository;



    public DdosTeams searchTeam(final String registry) {
        List<TeamModel> teams = new LinkedList<>();
        Optional<TeachersModel> teacher = teacherRepository.findByRegistry(Integer.parseInt(registry));
        TeachersModel teachersModel = teacher.get();
        List<StudentModel> students = studentsRepository.findBySeries(teachersModel.getSerie());
        for(StudentModel studentModel : students){
            teams.add(new TeamModel(studentModel.getTeam()));
        }

        return new DdosTeams(teachersModel.getName(),teachersModel.getRegistry(),teams);
    }

}
