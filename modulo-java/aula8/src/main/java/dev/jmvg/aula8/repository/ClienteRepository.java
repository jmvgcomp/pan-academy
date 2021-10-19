package dev.jmvg.aula8.repository;

import dev.jmvg.aula8.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
