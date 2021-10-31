package dev.jmvg.aula19apicrudaws.repositories;

import dev.jmvg.aula19apicrudaws.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    List<Topico> findAllByTopicoTituloContainsIgnoreCase(String titulo);

}
