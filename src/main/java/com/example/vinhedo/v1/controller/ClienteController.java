package com.example.vinhedo.v1.controller;

import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.domain.Item;
import com.example.vinhedo.v1.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(value = "Clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Obter 3 melhores compradores ")
    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<Cliente>> obterClientesFieis() {
        return ResponseEntity.ok(clienteService.obterClientesFieis());
    }

    @ApiOperation(value = "Obter recomendação de vinho por tipo preferido")
    @GetMapping("/recomendacao/{id}/tipo")
    public ResponseEntity<Item> getRecomendacao(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.getRecomendacao(id));
    }
}
