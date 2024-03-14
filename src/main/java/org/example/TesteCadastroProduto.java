package org.example;

import org.example.model.DAO.CategoriaDAO;
import org.example.model.DAO.ProdutoDAO;
import org.example.model.entities.Categoria;
import org.example.model.entities.Produto;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TesteCadastroProduto {
    public static void main(String[] args) {
        salvaProduto();
        EntityManager em = JPAUtils.getEntityManager("loja");
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        produtoDAO.findByName("IPhone 15 Pro Max").forEach(produto -> System.out.println(produto));
        produtoDAO.findByCategoryName("TELEVISÃO").forEach(produto -> System.out.println(produto));

        System.out.println("preço: " + produtoDAO.findPriceByName("IPhone 15 Pro Max"));

        em.close();

    }

    private static void salvaProduto() {
        EntityManager em = JPAUtils.getEntityManager("loja");
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        Categoria celular = new Categoria("CELULAR");
        Categoria tv = new Categoria("TELEVISÃO");

        Produto cell = new Produto("IPhone 15 Pro Max",
                "IPhone 15 Pro Max 256Gigas",
                new BigDecimal("7500"),
                celular);
        Produto tv1 = new Produto("TV OLED 4k 80\"",
                "TV SAMSUNG BRABA OLED",
                new BigDecimal("25000"),
                tv);

        em.getTransaction().begin();

        categoriaDAO.save(celular);
        categoriaDAO.save(tv);
        produtoDAO.save(cell);
        produtoDAO.save(tv1);

        em.getTransaction().commit();

        em.close();
    }
}
