package com.example.vinhedo.v1.domain;

import com.example.vinhedo.v1.annotations.LocalDateFormatter;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Compra implements Comparable<Compra> {

    private String codigo;
    @LocalDateFormatter
    private LocalDate data;
    private String cliente;
    private List<Item> itens;
    private int valorTotal;

    @Override
    public int compareTo(Compra o) {
        if (this.valorTotal > o.getValorTotal()) {
            return -1;
        }
        if (this.valorTotal < o.getValorTotal()) {
            return 1;
        }
        return 0;
    }
}