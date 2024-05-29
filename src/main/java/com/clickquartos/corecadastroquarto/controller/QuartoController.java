package com.clickquartos.corecadastroquarto.controller;

import com.clickquartos.corecadastroquarto.dto.QuartoDTO;
import com.clickquartos.corecadastroquarto.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/quartos" )
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public QuartoDTO createQuarto( @RequestBody @Validated QuartoDTO quartoDTO ){

        return quartoService.createQuarto( quartoDTO );
    }

    @GetMapping
    @ResponseStatus( HttpStatus.OK )
    public List< QuartoDTO > findAll(){

        return quartoService.findAll();
    }

    @PutMapping( "/{codigoQuarto}" )
    @ResponseStatus( HttpStatus.OK )
    public void updateQuarto( @PathVariable ( "codigoQuarto" ) String codigoQuarto,
                              @RequestBody @Validated QuartoDTO quartoDTO ){

        quartoService.updateQuarto(codigoQuarto, quartoDTO);

    }

    @DeleteMapping("/{codigoQuarto}")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void updateQuarto( @PathVariable ( "codigoQuarto" ) String codigoQuarto ){

        quartoService.deleteQuarto(codigoQuarto);
    }


}