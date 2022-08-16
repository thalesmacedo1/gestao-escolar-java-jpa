package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.Professor;
import org.gestaoescolar.model.Escola;

public class ProfessorDAO {
    private EntityManager em;

    public ProfessorDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Professor professor) {
        this.em.getTransaction().begin();
        this.em.persist(professor);
        this.em.getTransaction().commit();

    }

    public void update(Professor professor) {
        this.em.getTransaction().begin();
        professor = this.em.merge(professor);
        this.em.persist(professor);
        this.em.getTransaction().commit();
    }

    public void delete(Professor professor) {
        this.em.getTransaction().begin();
        professor = this.em.merge(professor);
        this.em.remove(professor);
        this.em.getTransaction().commit();
    }

    public List<Professor> getAllTeachers() {
        String query = "SELECT p FROM Professor p";
        return this.em.createQuery(query, Professor.class).getResultList();
    }

    public Professor getTeachersById(Long id) {
        String query = "SELECT p FROM Professor p WHERE p.id = :id";
        return this.em.createQuery(query, Professor.class).setParameter("id", id).getSingleResult();
    }

    public List<Escola> getTeachersSchoolsById(Long id) {
        String query = "SELECT p FROM Professor p WHERE p.id = :id";

        Professor professor = this.em.createQuery(query, Professor.class).setParameter("id", id).getSingleResult();

        return professor.getEscolas();
    }
}
