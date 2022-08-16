package org.gestaoescolar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Semestre> semestres = new ArrayList<Semestre>();

    @ManyToMany(mappedBy = "cursosEscola")
    private List<Escola> escolas = new ArrayList<Escola>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_aluno")
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso() {
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

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public List<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        String result = "Curso: " + this.nome;

        return result;
    }
}