package dev.jmvg.aula19apicrudaws.controllers;

import dev.jmvg.aula19apicrudaws.entities.Texto;
import dev.jmvg.aula19apicrudaws.repositories.TextoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/texto")
@CrossOrigin("*")
public class TextoController {

    @Autowired
    private TextoRepository textoRepository;

    @GetMapping
    public ResponseEntity<List<Texto>> GetAll() {
        return ResponseEntity.ok(textoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Texto> GetById(@PathVariable long id) {
        return textoRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Texto> Post(@RequestBody Texto texto) {
        return ResponseEntity.ok(textoRepository.save(texto));
    }

    @PutMapping
    public ResponseEntity<Texto> put(@RequestBody Texto texto){
        return ResponseEntity.ok(textoRepository.save(texto));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        textoRepository.deleteById(id);
    }

}