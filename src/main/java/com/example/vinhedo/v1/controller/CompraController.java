package com.example.vinhedo.v1.controller;

import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.service.CompraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/compras")
    public ResponseEntity<List<Compra>> obterCompras() {
        return ResponseEntity.ok(compraService.getCompras());
    }

    @GetMapping("/maior-compra/{ano}")
    public ResponseEntity<Compra> obterMaiorCompraPorAno(@PathVariable("ano") Integer ano) {
        return ResponseEntity.ok(compraService.obterMaiorCompraPorAno(ano));
    }

}
