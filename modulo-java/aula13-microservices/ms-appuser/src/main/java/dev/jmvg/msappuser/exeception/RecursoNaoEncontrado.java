package dev.jmvg.msappuser.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Não foi encontrado")
public class RecursoNaoEncontrado extends RuntimeException {
}
