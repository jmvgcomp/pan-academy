package dev.jmvg.msappuser.services;

import dev.jmvg.msappuser.model.Usuario;
import dev.jmvg.msappuser.respository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    final
    UsuarioRepository userRepository;

    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> findAll(){
        return userRepository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return userRepository.findById(id);
    }

}
