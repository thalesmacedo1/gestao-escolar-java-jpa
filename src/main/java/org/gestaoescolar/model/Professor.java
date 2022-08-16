package org.gestaoescolar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    private String email;

    @Column(name = "data_nasc")
    private LocalDate dataNascimento;

    @ManyToMany(mappedBy = "professores")
    private List<Escola> Escolas = new ArrayList<Escola>();

    public Professor(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Escola> getEscolas() {
        return Escolas;
    }

    public void setEscolas(List<Escola> Escolas) {
        this.Escolas = Escolas;
    }

    @Override
    public String toString() {
        String result = "Nome: " + this.nome +
                "	| E-mail: " + this.email +
                "	| Data de nascimento: " + this.dataNascimento;

        return result;
    }
}