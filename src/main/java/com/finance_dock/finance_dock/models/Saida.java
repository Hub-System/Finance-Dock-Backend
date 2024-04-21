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
public class Saida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Date vencimento;
    @Column(nullable = false)
    private double valor;
    @ManyToOne
    @JoinColumn(name = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;
    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;

    public Saida() {
    }

    public Saida(Long id, String descricao, Date vencimento, double valor, TipoMovimentacao tipoMovimentacao) {
        this.id = id;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.valor = valor;
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

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    @Override
    public String toString() {
        return "Saida [id=" + id + ", descricao=" + descricao + ", vencimento=" + vencimento + ", valor=" + valor
                + ", tipoMovimentacao=" + tipoMovimentacao.getNome() + ", dashboard=" + dashboard + "]";
    }

}

