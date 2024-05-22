package com.projeto.seletinha.endpoint.controller;

import com.google.gson.Gson;
import com.projeto.seletinha.endpoint.service.NotaService;
import com.projeto.seletinha.models.NotaModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotasController {

    private final NotaService notaService;


    @RequestMapping(value = "/notas", method = RequestMethod.POST)
    public @ResponseBody String lançaNota(final HttpServletRequest request) {
        final String registry = request.getParameter("registry");
        final String idGamer = request.getParameter("idGamer");
        final String value = request.getParameter("value");
        final Gson json = new Gson();

        if (registry != null && idGamer != null && value != null) {
            notaService.create(new NotaModel(registry,idGamer,value));
        }
        return "Success!!";
    }

    @RequestMapping(value = "/notas", method = RequestMethod.GET)
    public @ResponseBody String pegarNota(final HttpServletRequest request) {
        final String registry = request.getParameter("registry");
        final String idGamer = request.getParameter("idGamer");
        final Gson json = new Gson();

        if (registry != null && idGamer != null) {
            List<NotaModel> list = notaService.buscaNotas(Integer.parseInt(registry),Integer.parseInt(idGamer));
            return json.toJson(list);
        }
        return "Erro";
    }

}
