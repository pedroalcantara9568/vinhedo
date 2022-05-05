package com.example.vinhedo.v1.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String codigo;
    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private String safra;
    private int preco;
}


