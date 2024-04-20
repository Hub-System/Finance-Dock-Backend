package com.finance_dock.finance_dock.models;

import java.util.List;

// Class definition
public class Dashboard {
    // Instance variables
    private List<Entrada> entradas;
    private List<Saida> saidas;
    private Usuario dono; // New attribute

    // Constructors
    public Dashboard() {
    }

    public Dashboard(List<Entrada> entradas, List<Saida> saidas, Usuario dono) {
        this.entradas = entradas;
        this.saidas = saidas;
        this.dono = dono;
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

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    // Other methods
    public double getSaldo() {
        double saldo = 0;
        for (Entrada entrada : entradas) {
            saldo += entrada.getValor();
        }
        for (Saida saida : saidas) {
            saldo -= saida.getValor();
        }
        return saldo;
    }

    public double getSaldoEntradas() {
        double saldo = 0;
        for (Entrada entrada : entradas) {
            saldo += entrada.getValor();
        }
        return saldo;
    }

    public double getSaldoSaidas() {
        double saldo = 0;
        for (Saida saida : saidas) {
            saldo += saida.getValor();
        }
        return saldo;
    }
}
