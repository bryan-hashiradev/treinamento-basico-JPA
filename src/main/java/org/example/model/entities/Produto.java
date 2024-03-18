package org.example.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
//caso nao utilize a tag table será utilizado o nome da classe como nome da tabela na base de dados
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    private String nome;
    @Column(name = "descricao") // o nome e outras props da coluna pode ser definido utilizando esta anotação
    private String desc;
    private BigDecimal preco;
    private LocalDate dataCriacao = LocalDate.now();
    // por padrao os relacionamentos ToOne tem o comportamento EAGER
    // e geram um left join com a tabela relacionada podendo causar
    // lentidao n e sobrecarga nas consultas por boa pratica sempre utilizar o fetchType lazy
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    public Produto(){}

    public Produto(String nome, String desc, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", preco=" + preco +
                ", dataCriacao=" + dataCriacao +
                ", categoria=" + categoria.getNome() +
                '}';
    }
}
