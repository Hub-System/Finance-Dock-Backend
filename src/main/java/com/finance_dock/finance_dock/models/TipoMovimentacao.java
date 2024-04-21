package com.finance_dock.finance_dock.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoMovimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 200, nullable = false)
    String nome;

    @OneToMany(mappedBy = "tipoMovimentacao", fetch = FetchType.EAGER)
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "tipoMovimentacao", fetch = FetchType.EAGER)
    private List<Saida> saidas;

    public TipoMovimentacao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoMovimentacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoMovimentacao [id=" + id + ", nome=" + nome + ", entradas=" + entradas + ", saidas=" + saidas + "]";
    }

}
