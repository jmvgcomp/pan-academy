package panacademy.squade2.awslambdas2t2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import panacademy.squade2.awslambdas2t2.modelo.Transacao;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {
}
