package com.example.aula2.controller;

import com.example.aula2.interfaces.IUsuario;
import com.example.aula2.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {
    @Autowired
    IUsuario usuario;

    @GetMapping
    public ResponseEntity<ResponseEntity<List<Usuario>>> getAll(){
        return ResponseEntity.ok(usuario.getAllBody());
    }

    @GetMapping("/listar/body")
    public ResponseEntity<List<Usuario>> getBody(){
        return ResponseEntity.ok(usuario.getAllBody().getBody());
    }

}
