package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.domain.Item;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CompraMock {
    public static Compra build(String cliente, List<Item> itemList, Integer valorTotal, LocalDate data) {

      return Compra.builder()
            .codigo("123456")
            .cliente(cliente)
            .data(data)
            .itens(itemList)
            .valorTotal(valorTotal)
            .build();
    }
}
