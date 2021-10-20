package dev.jmvg.aula8.controller;

import dev.jmvg.aula8.model.ClienteModel;
import dev.jmvg.aula8.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/listar/clientes")
    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes/salvar")
    ResponseEntity<ClienteModel> save(@RequestBody ClienteModel clientinho) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clientinho));
    }

    @GetMapping("/listar/{tipo}")
    public ResponseEntity<List<ClienteModel>> filtroPorId(@PathVariable Integer tipo) {
        return ResponseEntity.ok(clienteRepository.procuraTipoPessoas(tipo));
    }
}
