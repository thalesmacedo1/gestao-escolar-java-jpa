package org.gestaoescolar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "semestres")
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int semestre;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Semestre(int semestre) {
        this.semestre = semestre;
    }

    public Semestre() {}

    @Override
    public String toString() {
        String result = "Semestre: " + this.semestre +
                "	| " + this.curso;

        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
