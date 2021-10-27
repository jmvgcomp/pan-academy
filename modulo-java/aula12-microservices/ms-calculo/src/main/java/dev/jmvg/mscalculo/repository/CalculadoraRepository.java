package dev.jmvg.mscalculo.repository;

import dev.jmvg.mscalculo.entities.Calculadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {
}
