package com.projeto.seletinha.endpoint.controller;


import com.google.gson.Gson;
import com.projeto.seletinha.endpoint.service.AtividadesService;
import com.projeto.seletinha.models.AtividadeModel;
import com.projeto.seletinha.models.DdosAtividades;
import com.projeto.seletinha.models.ServiceModel;
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
public class AtividadeController {


    private final AtividadesService atividadesService;

    @RequestMapping(value = "/atividades", method = RequestMethod.POST)
    public @ResponseBody
    ServiceModel updateStudent(final HttpServletRequest request) {
        String team = request.getParameter("team");
        String serie = request.getParameter("serie");
        String nome = request.getParameter("nome");
        atividadesService.create(new AtividadeModel(serie, team, nome));

        return new ServiceModel(200, "Success!!");
    }


    @RequestMapping(value = "/atividades", method = RequestMethod.GET)
    public @ResponseBody String localizarAtividade(final HttpServletRequest request) {
        String registry = request.getParameter("registry");
        DdosAtividades ddos = atividadesService.localizar(Integer.parseInt(registry));

        return new Gson().toJson(ddos);
    }


}
