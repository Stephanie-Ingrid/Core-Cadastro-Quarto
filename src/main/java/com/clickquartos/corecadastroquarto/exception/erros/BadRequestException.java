package com.clickquartos.corecadastroquarto.exception.erros;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 7017118131995818584L;

    public BadRequestException( String message ){
        super( message );
    }
}
