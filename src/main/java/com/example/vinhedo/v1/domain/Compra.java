package com.example.vinhedo.v1.domain;

import com.example.vinhedo.v1.annotations.LocalDateFormatter;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Compra implements Comparable<Compra> {

    private String codigo;
    @LocalDateFormatter
    private LocalDate data;
    private String cliente;
    private List<Item> itens;
    private int valorTotal;

    @Builder
    public Compra(String codigo, LocalDate data, String cliente, List<Item> itens, int valorTotal) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

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