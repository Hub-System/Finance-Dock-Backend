package com.finance_dock.finance_dock.models;

import java.util.Date;

public class Entrada {
    private Long id;
    private String descricao;
    private double valor;
    private Date insercao;

    public Entrada() {
    }

    public Entrada(Long id, String descricao, double valor, Date insercao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.insercao = insercao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getInsercao() {
        return insercao;
    }

    public void setInsercao(Date insercao) {
        this.insercao = insercao;
    }
}