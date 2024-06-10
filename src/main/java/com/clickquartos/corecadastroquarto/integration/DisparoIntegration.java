package com.clickquartos.corecadastroquarto.integration;

import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailRequest;
import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(url = "${url.coredisparoemail}", value = "core-disparo-email")
public interface DisparoIntegration {

    @PostMapping("/send-mail")
    DisparoEmailResponse disparoEmail (@RequestBody DisparoEmailRequest disparoEmail);
}
