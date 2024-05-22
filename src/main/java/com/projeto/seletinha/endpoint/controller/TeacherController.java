package com.projeto.seletinha.endpoint.controller;

import com.google.gson.Gson;
import com.projeto.seletinha.endpoint.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController {

    private final TeacherService teacherService;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public @ResponseBody String searchTeams(final HttpServletRequest request) {
        final String parameter = request.getParameter("registry");
        final Gson json = new Gson();

        if (parameter != null) {
            return json.toJson(teacherService.searchTeam(parameter));
        }

        return "Favor informar a matricula";
    }
}
