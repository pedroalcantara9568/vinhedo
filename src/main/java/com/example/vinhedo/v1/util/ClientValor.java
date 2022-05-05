package com.example.vinhedo.v1.util;

import com.example.vinhedo.v1.domain.Cliente;
import lombok.Data;

@Data
public class ClientValor implements Comparable<ClientValor> {

    private Cliente cliente;
    private Integer valor;

    public ClientValor(Cliente cliente, Integer valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    @Override
    public int compareTo(ClientValor o) {
        if (this.valor > o.getValor()) {
            return -1;
        }
        if (this.valor < o.getValor()) {
            return 1;
        }
        return 0;
    }
}
