package dev.jmvg.mscalculadora.services;

import dev.jmvg.mscalculadora.WorkerFeignClient;
import dev.jmvg.mscalculadora.model.Calculadora;
import dev.jmvg.mscalculadora.model.Tabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	//na calculadora deste projeto, passa duas variaveis
	public Calculadora getCalculo(long tabelaId, int dias) {
		
	
	Tabela tabela = workerFeignClient.findById(tabelaId).getBody();
	//2 parte do controller	
	return new Calculadora(tabela.getPessoa(), tabela.getPrecoPorDia(), dias);
}

}













