package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.*;

public class EscolaDAO {
    private EntityManager em;

    public EscolaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Escola Escola) {
        this.em.getTransaction().begin();
        this.em.persist(Escola);
        this.em.getTransaction().commit();
    }

    public void update(Escola Escola) {
        this.em.getTransaction().begin();
        Escola = this.em.merge(Escola);
        this.em.persist(Escola);
        this.em.getTransaction().commit();
    }

    public void delete(Escola Escola) {
        this.em.getTransaction().begin();
        Escola = this.em.merge(Escola);
        this.em.remove(Escola);
        this.em.getTransaction().commit();
    }

    public List<Escola> getAllSchools() {
        String query = "SELECT e FROM Escola e";
        return this.em.createQuery(query, Escola.class).getResultList();
    }

    public Escola getSchoolById(Long id) {
        String query = "SELECT e FROM Escola e WHERE e.id = :id";
        return this.em.createQuery(query, Escola.class).setParameter("id", id).getSingleResult();
    }

    public Escola getSchoolByName(String nome) {
        String query = "SELECT e FROM Escola e WHERE e.nome = :nome";
        return this.em.createQuery(query, Escola.class).setParameter("nome", nome).getSingleResult();
    }

    public Empresa getSchoolCompanyById(Long id) {
        String query = "SELECT e FROM Escola e WHERE e.id = :id";

        Escola Escola = this.em.createQuery(query, Escola.class).setParameter("id", id)
                .getSingleResult();

        return Escola.getEmpresa();
    }

    public List<Professor> getSchoolTeachersById(Long id) {
        String query = "SELECT e FROM Escola e WHERE e.id = :id";

        Escola Escola = this.em.createQuery(query, Escola.class).setParameter("id", id)
                .getSingleResult();

        return Escola.getProfessores();
    }

    public List<Curso> getSchoolCoursesById(Long id) {
        String query = "SELECT e FROM Escola e WHERE e.id = :id";

        Escola Escola = this.em.createQuery(query, Escola.class).setParameter("id", id)
                .getSingleResult();

        return Escola.getCursosEscola();
    }
}
