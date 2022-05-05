package com.example.vinhedo.v1.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoriaQuantidade implements Comparable<CategoriaQuantidade> {

    private String categoria;
    private Integer quantidade;

    public CategoriaQuantidade(String categoria, Integer quantidade) {
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(CategoriaQuantidade o) {
        if (this.quantidade > o.getQuantidade()) {
            return -1;
        }
        if (this.quantidade < o.getQuantidade()) {
            return 1;
        }
        return 0;
    }
}
