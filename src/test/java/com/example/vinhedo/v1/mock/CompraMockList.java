package com.example.vinhedo.v1.mock;

import com.example.vinhedo.v1.domain.Compra;

import java.time.LocalDate;
import java.util.List;

public class CompraMockList {

    public static List<Compra> build() {
        return List.of(
            CompraMock.build("000.000.000-01", ItemMockList.build(), 150, LocalDate.of(2022,04,04)),
            CompraMock.build("000.000.000-01", ItemMockList.build(), 170, LocalDate.of(2020,04,04)),
            CompraMock.build("000.000.000-01", ItemMockList.build(), 151, LocalDate.of(2021,04,04))
        );
    }
}
