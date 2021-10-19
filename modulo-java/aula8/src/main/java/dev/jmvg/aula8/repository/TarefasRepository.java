package dev.jmvg.aula8.repository;

import dev.jmvg.aula8.model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
    List<TarefasModel> findAllByTarefaContainingIgnoreCase(String tarefa);
}
