package dev.jmvg.mscalculadora.resources;


import dev.jmvg.mscalculadora.Repo.CalculadoraRepository;
import dev.jmvg.mscalculadora.model.Calculadora;
import dev.jmvg.mscalculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/resultado")
public class CalculadoraResource {

	@Autowired
	private CalculadoraService service;

	@Autowired
	private CalculadoraRepository calculadoraRepository;
	
	@GetMapping(value = "/{tabelaId}/multiplique/{dias}")
	public ResponseEntity<Calculadora> getPayment(@PathVariable Long tabelaId, @PathVariable Integer dias) {
		Calculadora calculadora = service.getCalculo(tabelaId, dias);
		return ResponseEntity.ok(calculadora);
	}	
	
	@PostMapping
	ResponseEntity<Calculadora> post(@RequestBody Calculadora calculo) {

		return ResponseEntity.status(HttpStatus.CREATED).body(calculadoraRepository.save(calculo));
	}
	

}







