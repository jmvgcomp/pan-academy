package dev.jmvg.aula8.repository;

import dev.jmvg.aula8.model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
    List<TarefasModel> findAllByTarefaContainingIgnoreCase(String tarefa);

    public List<TarefasModel> findByTarefaAndId(String tarefa, Long id);

    public List<TarefasModel> findByTarefaOrId(String tarefa, Long id);

    @Query(value = "SELECT t FROM TarefasModel t")
    List<TarefasModel> procuraTodos();
}
