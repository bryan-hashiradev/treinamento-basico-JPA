package org.example.model.DAO;

import org.example.model.entities.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO extends DAO {

    public CategoriaDAO(EntityManager em) {
        super(em, Categoria.class);
    }
}
