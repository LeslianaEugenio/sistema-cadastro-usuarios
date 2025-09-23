package com.example.backend;

import com.example.backend.model.Usuario;
import com.example.backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository repositorio) {
        return args -> {
            if(repositorio.findByEmail("teste@email.com").isEmpty()) {
                Usuario u = new Usuario();
                u.setNome("Usuário Teste"); // adiciona o nome
                u.setEmail("teste@email.com");
                u.setPassword("123456"); // senha em texto puro
                repositorio.save(u);
            }
        };
    }

}
