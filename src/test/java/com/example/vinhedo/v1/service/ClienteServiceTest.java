package com.example.vinhedo.v1.service;

import com.example.vinhedo.v1.client.impl.ClienteClientImpl;
import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.domain.Item;
import com.example.vinhedo.v1.exception.ResourceNotFoundException;
import com.example.vinhedo.v1.mock.ClienteMockList;
import com.example.vinhedo.v1.mock.CompraMockList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteClientImpl clienteClient;

    @Mock
    private CompraService compraService;

    @InjectMocks
    ClienteService clienteService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getRecomendacao() {
        Mockito.when(clienteClient.getClientes()).thenReturn(ClienteMockList.build());
        Mockito.when(compraService.obterCompras(any())).thenReturn(CompraMockList.build());
        Item recomendacao = clienteService.getRecomendacao(1);
        Assertions.assertNotNull(recomendacao);
    }

    @Test
    void getRecomendacaoClienteSemCompra() {
        Mockito.when(clienteClient.getClientes()).thenReturn(ClienteMockList.build());

        assertThrows(ResourceNotFoundException.class, () -> clienteService.getRecomendacao(7));
    }

    @Test
    void getRecomendacaoClienteNaoExiste() {
        Mockito.when(clienteClient.getClientes()).thenReturn(ClienteMockList.build());

        assertThrows(ResourceNotFoundException.class, () -> clienteService.getRecomendacao(7));
    }

    @Test
    void obterClientesFieis() {
        Mockito.when(clienteClient.getClientes()).thenReturn(ClienteMockList.build());
        Mockito.when(compraService.getCompras()).thenReturn(CompraMockList.build());

        List<Cliente> clientes = clienteService.obterClientesFieis();

        Assertions.assertNotNull(clientes);
    }
}