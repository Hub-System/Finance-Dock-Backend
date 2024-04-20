package com.finance_dock.finance_dock.models;

import java.util.Date;

public class Saida {
    private Long id;
    private String descricao;
    private Date vencimento;
    private double valor;
    private TipoSaida tipoSaida;

    public Saida() {
    }

    public Saida(Long id, String descricao, Date vencimento, double valor, TipoSaida tipoSaida) {
        this.id = id;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.valor = valor;
        this.tipoSaida = tipoSaida;
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

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoSaida getTipoSaida() {
        return tipoSaida;
    }

    public void setTipoSaida(TipoSaida tipoSaida) {
        this.tipoSaida = tipoSaida;
    }

}

