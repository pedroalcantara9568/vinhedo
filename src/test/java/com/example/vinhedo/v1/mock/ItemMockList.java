package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Item;

import java.util.List;

public class ItemMockList {


    public static List<Item> build() {

        return List.of(
            ItemMock.build("Tinto", "Chile", "Casa Silva Reserva", "2014", "Cabernet Sauvignon", 70),
            ItemMock.build("Tinto", "Chile", "Casa Silva Gran Reserva", "2009", "Petit Verdot", 120),
            ItemMock.build("Tinto", "Brasil", "Casa de Manoel", "2014", "Quem sabe", 70),
            ItemMock.build("Tinto", "Brasil", "Padre Cicero", "2022", "Sauvignon", 45)
        );

    }

}
