package org.example.model.DAO;

import org.example.model.entities.Pedido;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO extends DAO{
    public PedidoDAO(EntityManager em) {
        super(em, Pedido.class);
    }

    public BigDecimal valorTotalPedidos() {
        String jpql = "SELECT SUM(p.valorTotal) FROM " +
                this.entityClass.getSimpleName() +
                " p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();

    }

    public List<Object[]> relatorioDeVendas() {
        String jpql = "SELECT produto.nome, SUM(item.quantidade) as quantidadeTotal, MAX(pedido.dataPedido) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY quantidadeTotal DESC";
        System.out.println(jpql);
        return em.createQuery(jpql, Object[].class).getResultList();
    }
}
