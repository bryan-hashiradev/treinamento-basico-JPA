package org.example;

import org.example.model.DAO.CategoriaDAO;
import org.example.model.DAO.ClienteDAO;
import org.example.model.DAO.PedidoDAO;
import org.example.model.DAO.ProdutoDAO;
import org.example.model.entities.*;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CadastroPedido {
    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        seed(em, produtoDAO, categoriaDAO, clienteDAO);
        Cliente cliente = (Cliente) clienteDAO.findByID(1l);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(pedido, 1, (Produto) produtoDAO.findByID(1l)));
        pedido.adicionarItem(new ItemPedido(pedido, 2, (Produto) produtoDAO.findByID(3l)));

        em.getTransaction().begin();
        pedidoDAO.save(pedido);
        em.getTransaction().commit();

        pedidoDAO.list().forEach(System.out::println);

        System.out.println("Valor total dos pedidos = " + pedidoDAO.valorTotalPedidos());

        pedidoDAO.relatorioDeVendas().forEach(System.out::println);

//        produtoDAO.list().forEach(System.out::println);
        em.close();

    }

    private static void seed(EntityManager em,
                             ProdutoDAO produtoDAO,
                             CategoriaDAO categoriaDAO,
                             ClienteDAO clienteDAO) {
        List<Categoria> categorias = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        categorias.add(new Categoria("CELULAR"));
        categorias.add(new Categoria("VIDEO-GAME"));
        categorias.add(new Categoria("TELEVISÃO"));
        categorias.add(new Categoria("COMPUTADOR"));


        produtos.add(new Produto(
                "IPhone Xr",
                "celular apple high tech",
                new BigDecimal("2000"),
                categorias.get(0)
        ));
        produtos.add(new Produto(
                "Playstation V",
                "video jogo da sony bom a pampa",
                new BigDecimal("4300"),
                categorias.get(1)
        ));
        produtos.add(new Produto(
                "TV OLED 60\"",
                "TV samsung bom a pampa",
                new BigDecimal("3400"),
                categorias.get(2)
        ));
        produtos.add(new Produto(
                "ACER NITRO XVI",
                "Notebook gamer Bom a pampa",
                new BigDecimal("12000"),
                categorias.get(3)
        ));

        clientes.add(new Cliente("12312312312", "bryan gomes"));
        clientes.add(new Cliente("12345678990", "renan gomes"));
        clientes.add(new Cliente("23242342432", "debora gomes"));
        em.getTransaction().begin();

        categorias.forEach(categoriaDAO::save);
        produtos.forEach(produtoDAO::save);
        clientes.forEach(clienteDAO::save);
        em.getTransaction().commit();

    }
}
