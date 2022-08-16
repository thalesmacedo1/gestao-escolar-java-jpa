package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.*;

public class CursoDAO {
    private EntityManager em;

    public CursoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Curso curso) {
        this.em.getTransaction().begin();
        this.em.persist(curso);
        this.em.getTransaction().commit();
    }

    public void update(Curso curso) {
        this.em.getTransaction().begin();
        curso = this.em.merge(curso);
        this.em.persist(curso);
        this.em.getTransaction().commit();
    }

    public void delete(Curso curso) {
        this.em.getTransaction().begin();
        curso = this.em.merge(curso);
        this.em.remove(curso);
        this.em.getTransaction().commit();
    }

    public List<Curso> getAllCourses() {
        String query = "SELECT c FROM Curso c";
        return this.em.createQuery(query, Curso.class).getResultList();
    }

    public Curso getCourseById(Long id) {
        String query = "SELECT c FROM Curso c WHERE c.id = :id";
        return this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();
    }

    public Curso getCourseByName(String nome) {
        String query = "SELECT c FROM Curso c WHERE c.nome = :nome";
        return this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();
    }

    public List<Aluno> getCourseStudentsById(Long id) {
        String query = "SELECT c FROM Curso c WHERE c.id = :id";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

        return curso.getAlunos();
    }

    public List<Aluno> getCourseStudentsByName(String nome) {
        String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

        return curso.getAlunos();
    }

    public List<Semestre> getCourseSemesterById(Long id) {
        String query = "SELECT c FROM Curso c WHERE c.id = :id";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

        return curso.getSemestres();
    }

    public List<Semestre> getCoursesSemesterByName(String nome) {
        String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

        return curso.getSemestres();
    }

    public List<Escola> getCoursesSchoolById(Long id) {
        String query = "SELECT c FROM Curso c WHERE c.id = :id";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

        return curso.getEscolas();
    }

    public List<Escola> getCoursesSchoolByName(String nome) {
        String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

        Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

        return curso.getEscolas();
    }
}
