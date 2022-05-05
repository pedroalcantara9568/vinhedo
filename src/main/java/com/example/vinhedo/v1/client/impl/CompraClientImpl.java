package com.example.vinhedo.v1.client.impl;

import com.example.vinhedo.v1.client.CompraClient;
import com.example.vinhedo.v1.domain.Compra;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CompraClientImpl {

    CompraClient compraClient;

    public List<Compra> getCompras() {
        try {
            log.info("consultando serviço de compras");
            var compras = compraClient.obterCompras();
            log.info("compras: {}", compras);
            return compras;
        } catch (Exception e) {
            log.info("Erro ao consultar serviço de compras");
            throw e;
        }
    }
}
