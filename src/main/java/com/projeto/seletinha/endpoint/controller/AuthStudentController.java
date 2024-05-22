package com.projeto.seletinha.endpoint.controller;


import com.projeto.seletinha.endpoint.service.AuthStudentService;
import com.projeto.seletinha.models.ServiceModel;
import com.projeto.seletinha.models.StudentModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthStudentController {

    private final AuthStudentService authStudentService;



    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public @ResponseBody
    ServiceModel createStudent(final HttpServletRequest request) {
        String registry = request.getParameter("registry");

        StudentModel studentModel = authStudentService.searchId(registry);

        if(studentModel != null){
            return new ServiceModel(200, "Success");
        }

        return new ServiceModel(403, "Aluno não encontrado.");
    }
}
