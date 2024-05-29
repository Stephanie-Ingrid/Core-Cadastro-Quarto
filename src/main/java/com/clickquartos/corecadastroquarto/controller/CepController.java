package com.clickquartos.corecadastroquarto.controller;

import com.clickquartos.corecadastroquarto.dto.EnderecoDTO;
import com.clickquartos.corecadastroquarto.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDTO buscaEnderecoCep(@PathVariable ("cep") String cep){

        return cepService.buscaEnderecoCep(cep);
    }


}
