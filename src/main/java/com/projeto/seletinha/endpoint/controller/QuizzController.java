package com.projeto.seletinha.endpoint.controller;


import com.google.gson.Gson;
import com.projeto.seletinha.endpoint.service.QuizzService;
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
public class QuizzController {

    private final QuizzService quizzService;


    @RequestMapping(value = "/quizz", method = RequestMethod.GET)
    public @ResponseBody String searchStudent(final HttpServletRequest request) {
        final String level = request.getParameter("nivel");
        final String type = request.getParameter("tipo");
        final String amount = request.getParameter("quantidade");
        final Gson json = new Gson();

        if (level != null && type != null && amount != null) {
            return json.toJson(quizzService.questions(level, type, Integer.parseInt(amount)));
        }
        return null;
    }


}
