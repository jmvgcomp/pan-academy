package dev.jmvg.msappuser.respository;

import dev.jmvg.msappuser.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
