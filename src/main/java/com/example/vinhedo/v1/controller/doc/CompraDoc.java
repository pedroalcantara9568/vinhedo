package com.example.vinhedo.v1.controller.doc;

import com.example.vinhedo.v1.annotations.DefaultSwaggerMapping;
import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.domain.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CompraDoc {

    @DefaultSwaggerMapping
    public ResponseEntity<List<Compra>> obterCompras();

    @DefaultSwaggerMapping
    public ResponseEntity<Compra> obterMaiorCompraPorAno(@PathVariable("ano") Integer ano);

    @DefaultSwaggerMapping
    public ResponseEntity<List<Cliente>> obterClientesFieis();

    @DefaultSwaggerMapping
    public ResponseEntity<Item> getRecomendacao(@PathVariable("id") Integer id);
}
