package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Usuario;
import java.util.Optional;

//interface de acesso ao banco
public interface UserRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
