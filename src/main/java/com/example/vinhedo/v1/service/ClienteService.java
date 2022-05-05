package com.example.vinhedo.v1.service;


import com.example.vinhedo.v1.client.impl.ClienteClientImpl;
import com.example.vinhedo.v1.domain.Cliente;
import com.example.vinhedo.v1.domain.Compra;
import com.example.vinhedo.v1.domain.Item;
import com.example.vinhedo.v1.exception.ResourceNotFoundException;
import com.example.vinhedo.v1.util.CategoriaQuantidade;
import com.example.vinhedo.v1.util.ClientValor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.vinhedo.v1.util.CpfUtil.formatarCpf;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteClientImpl clienteClient;

    @Autowired
    private CompraService compraService;

    public Item getRecomendacao(Integer id) {
        var clientes = clienteClient.getClientes();
        Cliente cliente = obterCliente(id, clientes);
        return obterRecomendacao(cliente);
    }

    public List<Cliente> obterClientesFieis() {
        var client = clienteClient.getClientes();
        var compras = compraService.getCompras();
        return obterClientesEValores(client, compras).stream()
            .sorted()
            .collect(Collectors.toList()).subList(0, 3)
            .stream().map(ClientValor::getCliente).collect(Collectors.toList());
    }

    private Cliente obterCliente(Integer id, List<Cliente> client) {
        return client.stream()
            .filter(cliente -> cliente.getId().equals(id)).findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Não existe cliente para o id: " + id));
    }

    private List<ClientValor> obterClientesEValores(List<Cliente> clientes, List<Compra> compras) {
        var clienteEValores = new ArrayList<ClientValor>();
        clientes.forEach(cliente -> {
            var valorTotal = compras.stream()
                .filter(compra -> formatarCpf(compra.getCliente()).equals(formatarCpf(cliente.getCpf())))
                .reduce(0, (valorTotalParcial, compra) -> valorTotalParcial + compra.getValorTotal(), Integer::sum);
            clienteEValores.add(new ClientValor(cliente, valorTotal));
        });
        return clienteEValores;
    }

    private Item obterRecomendacao(Cliente cliente) {
        var comprasPorCliente = compraService.obterCompras(cliente);
        Set<String> categorias = obterCategorias(comprasPorCliente);
        Optional<CategoriaQuantidade> categoriaMaisComprada = obterCategoriaMaisComprada(comprasPorCliente, categorias);
        return comprasPorCliente.stream()
            .map(Compra::getItens)
            .flatMap(items -> items.stream().filter(item1 -> item1.getCategoria().equals(categoriaMaisComprada.get().getCategoria())))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow(() -> new ResourceNotFoundException("Não existe Compra para o cliente buscado"));
    }

    private Set<String> obterCategorias(List<Compra> collect) {
        return collect.stream()
            .map(Compra::getItens)
            .flatMap(items -> items.stream().map(Item::getCategoria))
            .collect(Collectors.toSet());
    }

    private Optional<CategoriaQuantidade> obterCategoriaMaisComprada(List<Compra> collect, Set<String> categorias) {
        List<CategoriaQuantidade> quantidades = new ArrayList<>();
        categorias.forEach(categoria -> {
            var collect1 = collect.stream().map(Compra::getItens)
                .flatMap(items -> items.stream().filter(item -> item.getCategoria().equals(categoria)))
                .reduce(0, (contador, item) -> contador + 1, Integer::sum);
            quantidades.add(new CategoriaQuantidade(categoria, collect1));
        });
        return quantidades.stream().sorted().collect(Collectors.toList()).stream().findFirst();
    }
}
