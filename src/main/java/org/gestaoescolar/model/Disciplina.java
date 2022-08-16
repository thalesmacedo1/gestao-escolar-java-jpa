package org.gestaoescolar.model;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        String result = "Disciplina: " + this.nome +
                "	| " + this.semestre;

        return result;
    }
}
