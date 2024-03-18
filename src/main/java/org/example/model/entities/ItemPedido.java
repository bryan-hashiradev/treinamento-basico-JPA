package org.example.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "preco_unitario")

    private BigDecimal precoUnitario;
    private int quantidade;
    // por padrao os relacionamentos ToOne tem o comportamento EAGER
    // e geram um left join com a tabela relacionada podendo causar
    // lentidao n e sobrecarga nas consultas por boa pratica sempre utilizar o fetchType lazy
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                ", produto=" + produto +
                '}';
    }

    public BigDecimal getValorTotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}
