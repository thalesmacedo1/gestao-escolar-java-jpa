package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.Disciplina;
import org.gestaoescolar.model.Semestre;

public class DisciplinaDAO {
    private EntityManager em;

    public DisciplinaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Disciplina disciplina) {
        this.em.getTransaction().begin();
        this.em.persist(disciplina);
        this.em.getTransaction().commit();
    }

    public void update(Disciplina disciplina) {
        this.em.getTransaction().begin();
        disciplina = this.em.merge(disciplina);
        this.em.persist(disciplina);
        this.em.getTransaction().commit();
    }

    public void delete(Disciplina disciplina) {
        this.em.getTransaction().begin();
        disciplina = this.em.merge(disciplina);
        this.em.remove(disciplina);
        this.em.getTransaction().commit();
    }

    public List<Disciplina> getAllDisciplines() {
        String query = "SELECT dO FROM Disciplina dO";
        return this.em.createQuery(query, Disciplina.class).getResultList();
    }

    public Disciplina getDisciplinesById(Long id) {
        String query = "SELECT dO FROM Disciplina dO WHERE dO.id = :id";

        return this.em.createQuery(query, Disciplina.class).setParameter("id", id).getSingleResult();
    }

    public Disciplina getDisciplinesByName(String nome) {
        String query = "SELECT dO FROM Disciplina dO WHERE dO.nome = :nome";

        return this.em.createQuery(query, Disciplina.class).setParameter("nome", nome).getSingleResult();
    }

    public Semestre getDisciplineSemesterById(Long id) {
        String query = "SELECT dO FROM Disciplina dO WHERE dO.id = :id";

        Disciplina disciplina = this.em.createQuery(query, Disciplina.class).setParameter("id", id).getSingleResult();

        return disciplina.getSemestre();
    }

    public Semestre getDisciplineSemesterByName(String nome) {
        String query = "SELECT dO FROM Disciplina dO WHERE dO.nome = :nome";

        Disciplina disciplina = this.em.createQuery(query, Disciplina.class)
                .setParameter("nome", nome).getSingleResult();

        return disciplina.getSemestre();
    }

}
