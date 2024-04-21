package com.finance_dock.finance_dock.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private Date insercao;
    @ManyToOne
    @JoinColumn(name = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;
    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;

    public Entrada() {
    }

    public Entrada(Long id, String descricao, double valor, Date insercao, TipoMovimentacao tipoMovimentacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.insercao = insercao;
        this.tipoMovimentacao = tipoMovimentacao;
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

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}