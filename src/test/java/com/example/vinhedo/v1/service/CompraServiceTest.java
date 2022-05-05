package com.example.vinhedo.v1.service;

import com.example.vinhedo.v1.client.impl.CompraClientImpl;
import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.exception.ResourceNotFoundException;
import com.example.vinhedo.v1.mock.CompraMock;
import com.example.vinhedo.v1.mock.CompraMockList;
import com.example.vinhedo.v1.mock.ItemMockList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CompraServiceTest {

    @Mock
    CompraClientImpl compraClient;

    @InjectMocks
    CompraService compraService;

    @Test
    void getCompras() {
        List<Compra> expected = CompraMockList.build().stream().sorted().collect(Collectors.toList());
        Mockito.when(compraClient.obterCompras()).thenReturn(expected);
        List<Compra> result = compraService.getCompras();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void obterMaiorCompraPorAno() {
        Compra expected = CompraMock.build("000.000.000-01", ItemMockList.build(), 150, LocalDate.of(2022, 04, 04));
        Mockito.when(compraClient.obterCompras()).thenReturn(List.of(expected));
        Compra result = compraService.obterMaiorCompraPorAno(2022);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void obterMaiorCompraPorAnoException() {
        Mockito.when(compraClient.obterCompras()).thenReturn(CompraMockList.build());

        assertThrows(ResourceNotFoundException.class, () -> compraService.obterMaiorCompraPorAno(2050));
    }

    @Test
    void obterCompras() {
        List<Compra> expected = CompraMockList.build();
        Mockito.when(compraClient.obterCompras()).thenReturn(expected);
        List<Compra> result = compraService.obterCompras("000.000.000-01");
        Assertions.assertEquals(expected, result);
    }
}