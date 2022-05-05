package com.example.vinhedo.v1.client.impl;

import com.example.vinhedo.v1.client.ClienteClient;
import com.example.vinhedo.v1.domain.Cliente;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ClienteClientImpl {

    ClienteClient clienteClient;

    public List<Cliente> getClientes() {
        try {
            log.info("consultando serviço de compras");
            var clientes = clienteClient.obterClientes();
            log.info("compras: {}", clientes);
            return clientes;
        } catch (FeignException e) {
            log.info("Erro ao consultar serviço de compras");
            throw e;
        }
    }
}
