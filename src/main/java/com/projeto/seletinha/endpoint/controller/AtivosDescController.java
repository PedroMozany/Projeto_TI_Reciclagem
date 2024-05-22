package com.projeto.seletinha.endpoint.controller;

import com.google.gson.Gson;
import com.projeto.seletinha.endpoint.service.AtivosDescService;
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
public class AtivosDescController {

    private final AtivosDescService ativosDescService;


    @RequestMapping(value = "/ativosDesc", method = RequestMethod.GET)
    public @ResponseBody String searchAtivos(final HttpServletRequest request) {
        final String parameter = request.getParameter("zone");
        final Gson json = new Gson();
        if (parameter != null) {
            return json.toJson(ativosDescService.searchZone(parameter));
        }
        return json.toJson(ativosDescService.searchAll());
    }

}
