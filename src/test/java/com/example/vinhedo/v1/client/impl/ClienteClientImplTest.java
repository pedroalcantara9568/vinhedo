package com.example.vinhedo.v1.client.impl;

import com.example.vinhedo.v1.client.ClienteClient;
import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.mock.ClienteMockList;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ClienteClientImplTest {


    @Mock
    ClienteClient clienteClient;

    @InjectMocks
    ClienteClientImpl clienteClientImpl;

    @Test
    void getClientes() {
        List<Cliente> expected = ClienteMockList.build();
        Mockito.when(clienteClient.obterClientes()).thenReturn(expected);

        List<Cliente> result = clienteClientImpl.getClientes();

        assertEquals(expected, result);
    }

    @Test
    void getClientesException() {
        Mockito.when(clienteClient.obterClientes()).thenThrow(new RuntimeException("erro de rede"));


        assertThrows(RuntimeException.class, () -> clienteClient.obterClientes());
    }
}