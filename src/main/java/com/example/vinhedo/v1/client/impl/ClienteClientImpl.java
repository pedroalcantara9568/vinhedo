package com.example.vinhedo.v1.client.impl;

import com.example.vinhedo.v1.client.ClienteClient;
import com.example.vinhedo.v1.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@CacheConfig(cacheNames={"clientes"})
public class ClienteClientImpl {

    @Autowired
    ClienteClient clienteClient;

    @Cacheable
    public List<Cliente> getClientes() {
        try {
            log.info("consultando serviço de compras");
            var clientes = clienteClient.obterClientes();
            log.info("compras: {}", clientes);
            return clientes;
        } catch (Exception e) {
            log.info("Erro ao consultar serviço de compras");
            throw e;
        }
    }
}
