package com.example.backend.service;

import com.example.backend.model.Usuario;
import com.example.backend.repository.UserRepository;
import com.example.backend.seguranca.JwtUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repositorio;
    private final JwtUtil jwt;

    public UserService(UserRepository repositorio, JwtUtil jwt) {
        this.repositorio = repositorio;
        this.jwt = jwt;
    }

    public Usuario cadastrarUsuario(Usuario u) {

        return repositorio.save(u);
    }

    public String login(String email, String password) {
        Optional<Usuario> u = repositorio.findByEmail(email);
        if(u.isPresent() && u.get().getPassword().equals(password)) {
            return jwt.generateToken(u.get().getEmail());
        }
        return null;
    }

    public List<Usuario> listAll() {
        return repositorio.findAll();
    }

    public boolean validate(String token) {
        return jwt.validateToken(token);
    }
}
