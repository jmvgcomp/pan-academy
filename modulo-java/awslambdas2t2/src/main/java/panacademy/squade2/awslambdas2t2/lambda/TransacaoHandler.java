package panacademy.squade2.awslambdas2t2.lambda;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import panacademy.squade2.awslambdas2t2.modelo.Transacao;

import java.util.Optional;

public class TransacaoHandler extends SpringBootRequestHandler<Long, Optional<Transacao>> {
}
