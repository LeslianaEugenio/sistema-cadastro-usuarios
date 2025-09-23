package com.example.backend.controller;

import com.example.backend.model.Usuario;
import com.example.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/geral")
public class ControloGeral {

    private final UserService service;

    public ControloGeral(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario u) {
        String token = service.login(u.getEmail(), u.getPassword());
        if(token != null) return ResponseEntity.ok("Token: " + token);
        else return ResponseEntity.status(401).body("Email ou senha errados");
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(@RequestHeader("Authorization") String auth) {
        if(auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            if(service.validate(token)) {
                return ResponseEntity.ok(service.listAll());
            }
        }
        return ResponseEntity.status(401).build();
    }
}
