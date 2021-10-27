package dev.jmvg.mscalculo.resource;

import dev.jmvg.mscalculo.entities.Calculadora;
import dev.jmvg.mscalculo.repository.CalculadoraRepository;
import dev.jmvg.mscalculo.services.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/resultado")
public class CalculadoraResource {
	private final CalculadoraService service;
	private final CalculadoraRepository repository;

	public CalculadoraResource(CalculadoraRepository repository, CalculadoraService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping(value = "/{tabelaId}/multiplique/{dias}")
	public ResponseEntity<Calculadora> getPayment(@PathVariable Long tabelaId, @PathVariable Integer dias) {
		Calculadora calculadora = service.getCalculo(tabelaId, dias);
		return ResponseEntity.ok(calculadora);
	}

	@PostMapping
	ResponseEntity<Calculadora> post(@RequestBody Calculadora calc) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(calc));
	}

}

