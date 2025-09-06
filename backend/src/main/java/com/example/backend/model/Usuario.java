package com.example.backend.model;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")

//classe onde vou execcutar toda a logica, entidades do banco
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    public Usuario(){}
    public Usuario(String nome, String email, String password){
            this.nome = nome;
            this.email = email;
            this.password = password;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
