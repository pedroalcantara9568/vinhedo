package com.example.vinhedo.v1.client.impl;

import com.example.vinhedo.v1.client.CompraClient;
import com.example.vinhedo.v1.mock.CompraMockList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CompraClientImplTest {

    @Mock
    CompraClient compraClient;

    @InjectMocks
    CompraClientImpl compraClientImpl;

    @Test
    void getCompras() {
        var expected = CompraMockList.build();
        Mockito.when(compraClientImpl.getCompras()).thenReturn(expected);

        var result = compraClientImpl.getCompras();

        assertEquals(expected, result);
    }

    @Test
    void getClientesException() {
        Mockito.when(compraClientImpl.getCompras()).thenThrow(new RuntimeException("erro de rede"));


        assertThrows(RuntimeException.class, () -> compraClientImpl.getCompras());
    }
}