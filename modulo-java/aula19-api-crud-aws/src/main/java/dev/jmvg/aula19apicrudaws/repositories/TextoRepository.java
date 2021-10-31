package dev.jmvg.aula19apicrudaws.repositories;

import dev.jmvg.aula19apicrudaws.entities.Texto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextoRepository extends JpaRepository<Texto, Long> {
}
