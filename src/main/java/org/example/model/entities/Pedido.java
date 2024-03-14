package org.example.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data_pedido")
    LocalDate dataPedido = LocalDate.now();
    @ManyToOne
    private Cliente cliente;
    @Column(name = "valor_total")

    private BigDecimal valorTotal = BigDecimal.ZERO;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // Relacionamento bi-direcional é preciso informar que é um relacionamento entre entidades ja mapeada por outro atributo. cascade propaga as operações para as entidades envolvidas
    private List<ItemPedido> itens = new ArrayList<>();

    Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    //em relacionamentos bi-direcionais deve-se fazer com que os dois lados se conhecam
    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getValorTotal());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", cliente=" + cliente +
                ", valorTotal=" + valorTotal +
                ", itens=" + itens.toString() +
                '}';
    }
}
