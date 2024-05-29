package com.clickquartos.corecadastroquarto.controller;

import com.clickquartos.corecadastroquarto.dto.MoradorDTO;
import com.clickquartos.corecadastroquarto.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public MoradorDTO cadastrarMorador(@RequestBody @Validated MoradorDTO moradorDTO){

        return moradorService.cadastrarMorador(moradorDTO);
    }

}
