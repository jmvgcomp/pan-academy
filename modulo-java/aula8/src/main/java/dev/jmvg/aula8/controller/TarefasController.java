package dev.jmvg.aula8.controller;


import dev.jmvg.aula8.model.TarefasModel;
import dev.jmvg.aula8.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefasController {
	
	Calendar c1 = Calendar.getInstance();
	int hora = c1.get(Calendar.HOUR_OF_DAY);

	private final TarefasRepository tarefasRepository;

	public TarefasController(TarefasRepository tarefasRepository) {
		this.tarefasRepository = tarefasRepository;
	}

	@GetMapping("/listar")
	public List<TarefasModel> findAll() {
		return tarefasRepository.findAll();
	}

	@GetMapping("/listar/condicional")
	public ResponseEntity<List<TarefasModel>> getAll() {
		if (hora > 9 && hora < 17) {
			System.out.println("entrou, dentro do horario");
			return ResponseEntity.ok(tarefasRepository.findAll());
		} else {
			System.out.println("fora do horario");
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<TarefasModel> save(@RequestBody TarefasModel tarefinha) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefasRepository.save(tarefinha));
	}

	@GetMapping("/listar/tarefas/{id}")
	public ResponseEntity<TarefasModel> getById(@PathVariable Long id) {
		return tarefasRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/listar/tarefas/{tarefa}")
	public ResponseEntity<List<TarefasModel>> getByTarefa(@PathVariable String tarefa) {
		return ResponseEntity.ok(tarefasRepository.findAllByTarefaContainingIgnoreCase(tarefa));
	}
}
