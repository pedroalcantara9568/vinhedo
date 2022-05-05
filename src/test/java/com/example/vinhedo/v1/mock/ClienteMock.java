package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Cliente;

public class ClienteMock {

    public static Cliente build(Integer id, String cpf, String nome) {
        return Cliente.builder()
            .id(id)
            .cpf(cpf)
            .nome(nome)
            .build();
    }

}
