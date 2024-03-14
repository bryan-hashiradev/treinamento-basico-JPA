package org.example.model.DAO;

import org.example.model.entities.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO extends DAO {

    public ProdutoDAO(EntityManager em) {
        super(em, Produto.class);
    }

    public List<Produto> findByName(String name) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
//        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";

        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", name)
                .getResultList();
    }
    public BigDecimal findPriceByName(String name) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
//        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";

        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", name)
                .getSingleResult();
    }

    public List<Produto> findByCategoryName(String name) {
        // jpql é orientado a objeto por isso na sua sintaxe é utilizado o nome da entity e seus atributos
//        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";

        return em.createQuery(jpql, Produto.class)
                .setParameter(1, name)
                .getResultList();
    }
}
