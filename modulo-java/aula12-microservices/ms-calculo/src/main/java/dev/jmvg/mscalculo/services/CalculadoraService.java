package dev.jmvg.mscalculo.services;

import java.util.HashMap;
import java.util.Map;

import dev.jmvg.mscalculo.entities.Calculadora;
import dev.jmvg.mscalculo.entities.Tabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculadoraService {
	

	@Value("${mstabela.host}")
	private String microTabela;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//na calculadora deste projeto , passa duas variaveis
	public Calculadora getCalculo(Long tabelaId, int dias) {

		Map<String, String> urlParamentros = new HashMap<>();
		urlParamentros.put("id",""+tabelaId);
		Tabela tabela = restTemplate.getForObject(microTabela + "/tabela/{id}", Tabela.class, urlParamentros);

		return new Calculadora(tabela.getPessoa(), tabela.getPrecoPorDia(), dias);
	}

}
