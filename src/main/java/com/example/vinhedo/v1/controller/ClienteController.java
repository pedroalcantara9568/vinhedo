package com.example.vinhedo.v1.controller;

import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.domain.Item;
import com.example.vinhedo.v1.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<Cliente>> obterClientesFieis() {
        return ResponseEntity.ok(clienteService.obterClientesFieis());
    }

    @GetMapping("/recomendacao/{id}/tipo")
    public ResponseEntity<Item> getRecomendacao(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.getRecomendacao(id));
    }
}
