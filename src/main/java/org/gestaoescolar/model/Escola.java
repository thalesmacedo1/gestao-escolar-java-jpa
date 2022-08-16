package org.gestaoescolar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "escolas")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "escola_professor")
    private List<Professor> professores = new ArrayList<Professor>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "escola_curso")
    private List<Curso> cursosEscola = new ArrayList<Curso>();

    public Escola(String nome) {
        this.nome = nome;
    }

    public Escola() {
    }

    @Override
    public String toString() {
        String result = "Escola: " + this.nome +
                "	| " + this.empresa;

        return result;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Curso> getCursosEscola() {
        return cursosEscola;
    }

    public void setCursosEscola(List<Curso> cursosEscola) {
        this.cursosEscola = cursosEscola;
    }

}
