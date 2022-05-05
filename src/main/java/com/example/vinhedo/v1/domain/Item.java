package com.example.vinhedo.v1.domain;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Item {
    private String codigo;
    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private String safra;
    private int preco;

    @Builder
    public Item(String codigo,
                String produto,
                String variedade,
                String pais,
                String categoria,
                String safra,
                int preco) {
        this.codigo = codigo;
        this.produto = produto;
        this.variedade = variedade;
        this.pais = pais;
        this.categoria = categoria;
        this.safra = safra;
        this.preco = preco;
    }
}


