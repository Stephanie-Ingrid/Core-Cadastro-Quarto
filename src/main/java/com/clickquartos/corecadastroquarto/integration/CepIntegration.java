package com.clickquartos.corecadastroquarto.integration;

import com.clickquartos.corecadastroquarto.integration.model.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "${url.viacep}" , value = "viacep")
public interface CepIntegration {
    @GetMapping("/{cep}/json")
    EnderecoResponse buscaEnderecoCep (@PathVariable("cep") String cep);


}
