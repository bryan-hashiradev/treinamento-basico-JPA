package org.example.model.entities;

import org.example.model.DadosPessoais;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private DadosPessoais dadosPessoais;

    Cliente() {
    }

    public Cliente(String cpf, String nome) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return dadosPessoais.getCpf();
    }


    public String getNome() {

        return dadosPessoais.getNome();
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + dadosPessoais.getCpf() + '\'' +
                ", nome='" + dadosPessoais.getNome() + '\'' +
                '}';
    }
}
