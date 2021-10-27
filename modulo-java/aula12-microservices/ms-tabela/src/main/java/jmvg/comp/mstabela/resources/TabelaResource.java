package jmvg.comp.mstabela.resources;

import jmvg.comp.mstabela.entities.Tabela;
import jmvg.comp.mstabela.repository.TabelaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabela")
public class TabelaResource {

    private static Logger logger = LoggerFactory.getLogger(TabelaResource.class);

    private Environment env;

    private final TabelaRepository repository;

    public TabelaResource(Environment env, TabelaRepository repository) {
        this.env = env;
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Tabela>> findAll() {
        List<Tabela> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tabela> findById(@PathVariable Long id) {
        logger.info("PORT: "+env.getProperty("local.server.port"));
        String serverPort = env.getProperty("local.server.port");
        System.out.println("Port: "+serverPort);
        Tabela obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}

