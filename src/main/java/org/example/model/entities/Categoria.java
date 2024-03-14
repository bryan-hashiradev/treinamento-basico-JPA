package org.example.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(name = "data_criacao")
    private LocalDate dataCriacao = LocalDate.now();

    Categoria() {}
    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
