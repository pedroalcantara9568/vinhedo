package com.example.vinhedo.v1.domain;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;

    @Builder
    public Cliente(Integer id,
                   String nome,
                   String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
}
