package com.example.vinhedo.v1.domain;


import lombok.Data;

@Data
public class Item {
    private String codigo;
    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private String safra;
    private int preco;
}


