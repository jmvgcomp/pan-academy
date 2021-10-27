package dev.jmvg.msappuser;

import dev.jmvg.msappuser.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "appuser", url="localhost:8081", path="msappuser/usuarios")
public interface WorkerFeign {

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll();
}