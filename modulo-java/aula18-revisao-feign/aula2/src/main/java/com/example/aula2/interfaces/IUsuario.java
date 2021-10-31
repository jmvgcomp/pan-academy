package com.example.aula2.interfaces;

import com.example.aula2.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="app1", url="http://localhost:5001/usuario")
public interface IUsuario {

    @GetMapping
    List<Usuario> getAll();

    @GetMapping
    ResponseEntity<List<Usuario>> getAllBody();
}
