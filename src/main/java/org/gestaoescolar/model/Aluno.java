package org.gestaoescolar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String matricula;

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos = new ArrayList<Curso>();

    public Aluno(String nome, String matricula, LocalDate dataNascimento, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Aluno() {
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        String result = "Nome: " + this.nome +
                "	| Matricula: " + this.matricula +
                "	| Data de nascimento: " + this.dataNascimento +
                "	| E-mail: " + this.email;

        return result;
    }
}