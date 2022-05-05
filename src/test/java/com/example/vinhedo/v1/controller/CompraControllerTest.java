package com.example.vinhedo.v1.controller;

import com.example.vinhedo.v1.mock.ClienteMockList;
import com.example.vinhedo.v1.mock.CompraMock;
import com.example.vinhedo.v1.mock.CompraMockList;
import com.example.vinhedo.v1.mock.ItemMockList;
import com.example.vinhedo.v1.service.ClienteService;
import com.example.vinhedo.v1.service.CompraService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompraControllerTest {

    @Autowired
    CompraController compraController;

    @LocalServerPort
    private int port;

    @MockBean
    CompraService compraService;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void obterCompras() {
        Mockito.when(compraService.obterCompras(any())).thenReturn(CompraMockList.build());
        RestAssured.given().contentType(ContentType.JSON)
            .when()
            .get("/compras")
            .then().log().all()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    void obterMaiorCompraPorAno() {
        Mockito.when(compraService.obterMaiorCompraPorAno(any())).thenReturn(CompraMock.build("000.000.000-01", ItemMockList.build(),200, LocalDate.now()));

        RestAssured.given().contentType(ContentType.JSON)
            .when()
            .get("/maior-compra/2022")
            .then().log().all()
            .statusCode(HttpStatus.OK.value());
    }
}