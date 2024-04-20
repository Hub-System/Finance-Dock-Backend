package com.finance_dock.finance_dock.models;

public class TipoMovimentacao {
    Long id;
    String nome;

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

}
