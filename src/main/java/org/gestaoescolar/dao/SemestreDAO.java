package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.Disciplina;
import org.gestaoescolar.model.Semestre;

public class SemestreDAO {
    private EntityManager em;

    public SemestreDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Semestre semestre) {
        this.em.getTransaction().begin();
        this.em.persist(semestre);
        this.em.getTransaction().commit();
    }

    public void update(Semestre semestre) {
        this.em.getTransaction().begin();
        semestre = this.em.merge(semestre);
        this.em.persist(semestre);
        this.em.getTransaction().commit();
    }

    public void delete(Semestre semestre) {
        this.em.getTransaction().begin();
        semestre = this.em.merge(semestre);
        this.em.remove(semestre);
        this.em.getTransaction().commit();
    }

    public List<Semestre> getAllSemesters() {
        String query = "SELECT s FROM Semestre s";
        return this.em.createQuery(query, Semestre.class).getResultList();
    }

    public Semestre getSemesterById(Long id) {
        String query = "SELECT s FROM Semestre s WHERE s.id = :id";

        return this.em.createQuery(query, Semestre.class).setParameter("id", id).getSingleResult();
    }

    public List<Disciplina> getSemestersDisciplinesById(Long id) {
        String query = "SELECT s FROM Semestre s WHERE s.id = :id";

        Semestre semestre = this.em.createQuery(query, Semestre.class).setParameter("id", id)
                .getSingleResult();

        return semestre.getDisciplinas();
    }

    public List<Disciplina> getSemestersDisciplinesByName(String nome) {
        String query = "SELECT s FROM Semestre s WHERE s.id = :nome";

        Semestre semestre = this.em.createQuery(query, Semestre.class).setParameter("nome", nome)
                .getSingleResult();

        return semestre.getDisciplinas();
    }

}
