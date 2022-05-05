package com.example.vinhedo.v1.service;

import com.example.vinhedo.v1.client.impl.CompraClientImpl;
import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.vinhedo.v1.util.CpfUtil.formatarCpf;

@Service
@Slf4j
public class CompraService {

    @Autowired
    private CompraClientImpl compraClient;

    public List<Compra> getCompras() {
        return compraClient.getCompras()
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public Compra obterMaiorCompraPorAno(Integer ano) {
        return compraClient.getCompras()
            .stream()
            .filter(compra -> ano.equals(compra.getData().getYear()))
            .sorted()
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Não existe Compra para o o ano: " + ano + ""));
    }

    public List<Compra> obterCompras(String cpf) {
        return compraClient.getCompras()
            .stream()
            .filter(compra -> formatarCpf(cpf).equals(formatarCpf(compra.getCliente())))
            .collect(Collectors.toList());
    }

}
