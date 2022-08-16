package org.gestaoescolar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Escola> Escola = new ArrayList<Escola>();

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa() {
    }

    @Override
    public String toString() {
        String result = "Empresa: " + this.nome;

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

    public List<Escola> getEscolas() {
        return Escola;
    }

    public void setEscola(List<Escola> Escola) {
        this.Escola = Escola;
    }

}
