package jmvg.comp.mstabela.resources;

import jmvg.comp.mstabela.entities.Tabela;
import jmvg.comp.mstabela.repository.TabelaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabela")
public class TabelaResource {

    private final TabelaRepository tarefasRepository;

    public TabelaResource(TabelaRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    @GetMapping
    public ResponseEntity<List<Tabela>> findAll() {
        return ResponseEntity.ok(tarefasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tabela> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tarefasRepository.findById(id).get());
    }


}
