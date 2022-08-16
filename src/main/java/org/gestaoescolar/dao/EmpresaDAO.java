package org.gestaoescolar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.gestaoescolar.model.Empresa;
import org.gestaoescolar.model.Escola;

public class EmpresaDAO {

    private EntityManager em;

    public EmpresaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Empresa empresa) {
        this.em.getTransaction().begin();
        this.em.persist(empresa);
        this.em.getTransaction().commit();
    }

    public void update(Empresa empresa) {
        this.em.getTransaction().begin();
        empresa = this.em.merge(empresa);
        this.em.persist(empresa);
        this.em.getTransaction().commit();
    }

    public void delete(Empresa empresa) {
        this.em.getTransaction().begin();
        empresa = this.em.merge(empresa);
        this.em.remove(empresa);
        this.em.getTransaction().commit();
    }

    public List<Empresa> getAllCompanies() {
        String query = "SELECT e FROM Empresa e";
        return this.em.createQuery(query, Empresa.class).getResultList();
    }

    public List<Escola> getCompanySchoolsByName(String nome_empresa) {
        String query = "SELECT e FROM Empresa e WHERE e.nome = :nome_empresa";

        Empresa empresa = this.em.createQuery(query, Empresa.class).setParameter("nome_empresa", nome_empresa)
                .getSingleResult();

        return empresa.getEscolas();
    }

    public List<Escola> getCompanySchoolsById(Long id) {
        String query = "SELECT e FROM Empresa e WHERE e.id = :id";

        Empresa empresa = this.em.createQuery(query, Empresa.class).setParameter("id", id)
                .getSingleResult();

        return empresa.getEscolas();
    }

}