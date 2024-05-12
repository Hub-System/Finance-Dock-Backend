package com.finance_dock.finance_dock.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.ToString;

@ToString
@Entity
public class Dashboard {
    // Instance variables
    // ods 4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "dashboard")
    private List<Entrada> entradas;
    @OneToMany(mappedBy = "dashboard")
    private List<Saida> saidas;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Dashboard(Long id, List<Entrada> entradas, List<Saida> saidas, Usuario usuario) {
        this.id = id;
        this.entradas = entradas;
        this.saidas = saidas;
        this.usuario = usuario;
    }

    // Constructors
    public Dashboard() {
    }

    public Dashboard(Long id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    // Getters and setters
    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Saida> getSaidas() {
        return saidas;
    }

    public void setSaidas(List<Saida> saidas) {
        this.saidas = saidas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Other methods
    public double getSaldo() {
        double saidas = getSaldoSaidas();
        double entradas = getSaldoEntradas();

        return (entradas - saidas);
    }

    public double getSaldoEntradas() {
        double saldo = 0;
        if (entradas != null) {
            for (Entrada entrada : entradas) {
                saldo += entrada.getValor();
            }
        }
        return saldo;
    }

    public double getSaldoSaidas() {
        double saldo = 0;
        if (saidas != null) {
            for (Saida saida : saidas) {
                saldo -= saida.getValor();
            }
        }
        return saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
