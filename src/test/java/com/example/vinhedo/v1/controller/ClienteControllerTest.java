package com.example.vinhedo.v1.controller;

import com.example.vinhedo.v1.mock.ClienteMockList;
import com.example.vinhedo.v1.mock.ItemMock;
import com.example.vinhedo.v1.service.ClienteService;
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

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteControllerTest {

    @Autowired
    ClienteController clienteController;

    @LocalServerPort
    private int port;

    @MockBean
    ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void obterClientesFieis() {
        Mockito.when(clienteService.obterClientesFieis()).thenReturn(ClienteMockList.build());

        RestAssured.given().port(port).contentType(ContentType.JSON)
            .when()
            .get("/clientes-fieis")
            .then().log().all()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    void getRecomendacao() {
        Mockito.when(clienteService.getRecomendacao(any())).thenReturn(ItemMock.build("Tinto", "Chile", "Casa Silva Reserva", "2014", "Cabernet Sauvignon", 70));

        given()
            .port(port)
            .contentType(ContentType.JSON)
            .when()
            .get("/recomendacao/1/tipo")
            .then().log().all()
            .statusCode(HttpStatus.OK.value());
    }
}