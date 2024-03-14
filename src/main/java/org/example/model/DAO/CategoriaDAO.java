package org.example.model.DAO;

import org.example.model.entities.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Categoria cat) {
        em.persist(cat);
    }
}
