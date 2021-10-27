package dev.jmvg.mscalculo.services;

import dev.jmvg.mscalculo.WorkerFeignClient;
import dev.jmvg.mscalculo.entities.Calculadora;
import dev.jmvg.mscalculo.entities.Tabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {


	@Autowired
	private WorkerFeignClient workerFeignClient;

	//na calculadora deste projeto, passa duas variaveis
	public Calculadora getCalculo(long tabelaId, int dias) {


		Tabela tabela = workerFeignClient.findById(tabelaId).getBody();
		return new Calculadora(tabela.getPessoa(), tabela.getPrecoPorDia(), dias);
	}

}
