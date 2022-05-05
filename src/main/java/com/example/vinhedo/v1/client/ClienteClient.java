package com.example.vinhedo.v1.client;


import com.example.vinhedo.v1.domain.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "clientes-client", url = "http://www.mocky.io")
@Service
public interface ClienteClient {

    @GetMapping("/v2/598b16291100004705515ec5")
    List<Cliente> obterClientes();

}
