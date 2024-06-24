package com.clickquartos.corecadastroquarto.controller;

import com.clickquartos.corecadastroquarto.dto.EnderecoDTO;
import com.clickquartos.corecadastroquarto.service.CepService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
@Data
public class CepController {

    private CepService cepService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDTO buscaEnderecoCep(@PathVariable ("cep") String cep){

        return cepService.buscaEnderecoCep(cep);
    }


}
