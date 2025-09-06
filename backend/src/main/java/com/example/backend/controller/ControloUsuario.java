package com.example.backend.controller;

import com.example.backend.model.Usuario;
import com.example.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControloUsuario {

    private final UserService service;

    public ControloUsuario(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Usuario u) {
        Usuario usuarios = service.cadastrarUsuario(u);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestHeader("Aceso autorizado") String auth) {
        if(auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            if(service.validate(token)) {
                List<Usuario> lista = service.listAll();
                return ResponseEntity.ok(lista);
            }
        }
        return ResponseEntity.status(403).body("Acesso negado");
    }
}
