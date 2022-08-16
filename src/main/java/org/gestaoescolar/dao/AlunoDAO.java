package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.Aluno;
import org.gestaoescolar.model.Curso;

public class AlunoDAO {
    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Aluno aluno) {
        this.em.getTransaction().begin();
        this.em.persist(aluno);
        this.em.getTransaction().commit();
    }

    public void update(Aluno aluno) {
        this.em.getTransaction().begin();
        aluno = this.em.merge(aluno);
        this.em.persist(aluno);
        this.em.getTransaction().commit();
    }

    public void delete(Aluno aluno) {
        this.em.getTransaction().begin();
        aluno = this.em.merge(aluno);
        this.em.remove(aluno);
        this.em.getTransaction().commit();
    }

    public List<Aluno> getAllStudents() {
        String query = "SELECT a FROM Aluno a";

        return this.em.createQuery(query, Aluno.class).getResultList();
    }

    public Aluno getStudentById(Long id) {
        String query = "SELECT a FROM Aluno a WHERE a.id = :id";

        return this.em.createQuery(query, Aluno.class).setParameter("id", id).getSingleResult();
    }

    public Aluno getStudentByName(String nome) {
        String query = "SELECT a FROM Aluno a WHERE a.id = :nome";

        return this.em.createQuery(query, Aluno.class).setParameter("nome", nome).getSingleResult();
    }

    public List<Curso> getStudentCoursesById(Long id) {
        String query = "SELECT a FROM Aluno a WHERE a.id = :id";
        Aluno aluno = this.em.createQuery(query, Aluno.class).setParameter("id", id).getSingleResult();

        return aluno.getCursos();
    }

    public List<Curso> getStudentCoursesByName(String nome) {
        String query = "SELECT a FROM Aluno a WHERE a.id = :nome";
        Aluno aluno = this.em.createQuery(query, Aluno.class).setParameter("nome", nome).getSingleResult();

        return aluno.getCursos();
    }
}
