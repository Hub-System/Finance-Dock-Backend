package com.finance_dock.finance_dock.models;

public class TipoSaida {
    Long id;
    String nome;

    public TipoSaida(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoSaida() {
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
