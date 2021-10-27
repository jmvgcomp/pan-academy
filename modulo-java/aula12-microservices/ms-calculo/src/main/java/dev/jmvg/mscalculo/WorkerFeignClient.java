package dev.jmvg.mscalculo;

import dev.jmvg.mscalculo.entities.Tabela;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "mstabela", path = "/tabela")
public interface WorkerFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<Tabela> findById(@PathVariable Long id);
}