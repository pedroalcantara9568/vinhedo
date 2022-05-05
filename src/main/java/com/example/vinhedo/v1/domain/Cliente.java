package com.example.vinhedo.v1.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
}
