package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.dto.QuartoDTO;
import com.clickquartos.corecadastroquarto.documento.Quarto;
import com.clickquartos.corecadastroquarto.exception.erros.BadRequestException;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import com.clickquartos.corecadastroquarto.repository.QuartoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class QuartoServiceImplTest {

    @InjectMocks
    private QuartoServiceImpl quartoService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private QuartoRepository quartoRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    //@Test
    @DisplayName("Cria um quarto caso esteja tudo correto")
    void createQuartoCase1( ) {

        //OBJETOS DOS MOCKS

        Quarto quartoNaoSalvoMock = Quarto.builder()
                .valor(new BigDecimal("1850.00"))
                .descricao("Quarto normal")
                .build();

        Quarto quartoSalvoMock = Quarto.builder()
                .codigoQuarto("123456")
                .valor(new BigDecimal("1850.00"))
                .descricao("Quarto normal")
                .build();

        QuartoDTO quartoDTOSalvoMock= QuartoDTO.builder()
                .codigoQuarto("123456")
                .valor(new BigDecimal("1850.00"))
                .descricao("Quarto normal")
                .build();

        //MOCKS

        when (modelMapper.map(Mockito.any(), Mockito.eq(Quarto.class)))
                .thenReturn(quartoNaoSalvoMock);
        when(quartoRepository.save(Mockito.any()))
                .thenReturn(quartoSalvoMock);
        when(modelMapper.map(Mockito.any(), Mockito.eq(QuartoDTO.class)))
                .thenReturn(quartoDTOSalvoMock);

        //COMEÇOU O TESTE

        QuartoDTO quartoDTOEnviado = QuartoDTO.builder()
                .valor(new BigDecimal("1850.00"))
                .descricao("Quarto normal")
                .build();

        QuartoDTO quartoCadastrado = quartoService.createQuarto(quartoDTOEnviado);


        //COMECA VALIDACOES DO RESULTADO

        // verify(quartoRepository, times(1)).save(Mockito.any(Quarto.class));
        assertEquals("123456", quartoCadastrado.getCodigoQuarto());
        assertEquals(new BigDecimal("1850.00"), quartoCadastrado.getValor());
        assertEquals("Quarto normal", quartoCadastrado.getDescricao());
    }



    //@Test
    @DisplayName("lança exception quando o quarto está vazio")
    void UpdateQuartoCase1() {

        //OBJETOS DOS MOCKS
        Quarto quartoExistente = new Quarto();
        quartoExistente.setCodigoQuarto("789");

        //MOCKS
        when(quartoRepository.findById(Mockito.any())).thenReturn(Optional.of(quartoExistente));

        //COMECA VALIDACOES DO RESULTADO
        QuartoDTO quartoDTO = QuartoDTO.builder()
                .codigoQuarto("789")
                .build();

        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> quartoService.updateQuarto("789", quartoDTO));

        assertEquals("Quarto encontrado com campos nulos: 789", exception.getMessage());


    }

    //@Test
    @DisplayName("lança exception quando o quarto nao existe")
    void updateQuartoCase2() {

        //OBJETOS DOS MOCKS
        String codigoQuarto = "456";
        QuartoDTO quartoDTO = QuartoDTO.builder()
                .codigoQuarto(codigoQuarto)
                .build();

        //MOCKS
        when(quartoRepository.findById(codigoQuarto)).thenReturn(Optional.empty());

        //COMECA VALIDACOES DO RESULTADO
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> quartoService.updateQuarto(codigoQuarto, quartoDTO));

        assertEquals("Quarto nao encontrado: 456", exception.getMessage());

    }

}