package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Item;



public class ItemMock {
    public static Item build(String categoria, String pais, String produto, String safra, String variedade, Integer preco) {
        return Item.builder()
            .codigo("123456")
            .categoria(categoria)
            .pais(pais)
            .preco(preco)
            .produto(produto)
            .safra(safra)
            .variedade(variedade)
            .build();
    }
}
