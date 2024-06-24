package com.clickquartos.corecadastroquarto.controller;

import com.clickquartos.corecadastroquarto.dto.QuartoDTO;
import com.clickquartos.corecadastroquarto.service.QuartoService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping( "/quartos" )
@Data
public class QuartoController {

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
