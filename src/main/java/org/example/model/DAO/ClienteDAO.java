package org.example.model.DAO;

import org.example.model.entities.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO extends DAO {

    public ClienteDAO(EntityManager em) {
        super(em, Cliente.class);
    }
}
