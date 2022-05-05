package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Cliente;

import java.util.List;


public class ClienteMockList {


    public static List<Cliente> build() {
        return List.of(
            ClienteMock.build(1, "000.000.000-01", "Lorem"),
            ClienteMock.build(2, "000.000.000-02", "Ipsum"),
            ClienteMock.build(3, "000.000.000-03", "Josney"),
            ClienteMock.build(4, "000.000.000-04", "Lincolal"),
            ClienteMock.build(5, "000.000.000-06", "Adelio"));
    }
}
