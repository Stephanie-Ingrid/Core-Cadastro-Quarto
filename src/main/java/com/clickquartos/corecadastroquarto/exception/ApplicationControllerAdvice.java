package com.clickquartos.corecadastroquarto.exception;

import com.clickquartos.corecadastroquarto.exception.erros.BadRequestException;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler( NotFoundException.class )
    @ResponseStatus( NOT_FOUND )
    @ResponseBody
    public ApiErros handleNotFoundException( NotFoundException e ) {
        return new ApiErros(e.getMessage());
    }

    @ExceptionHandler( BadRequestException.class )
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ApiErros handleBadRequestException(BadRequestException e) {
        return new ApiErros(e.getMessage());
    }


    @ExceptionHandler( Exception.class )
    @ResponseStatus( INTERNAL_SERVER_ERROR )
    @ResponseBody
    public ApiErros handleGeneralException( Exception e ) {
        log.error(e.getMessage(), e);

        return new ApiErros( "Sistema Indisponivel, por favor tente mais tarde ou contate um administrador!" );
    }

}
