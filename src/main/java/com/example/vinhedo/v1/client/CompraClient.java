package com.example.vinhedo.v1.client;


import com.example.vinhedo.v1.domain.Compra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "compras-client", url = "http://www.mocky.io")
@Service
public interface CompraClient {

    @GetMapping("/v2/598b16861100004905515ec7")
    List<Compra> obterCompras();

}
