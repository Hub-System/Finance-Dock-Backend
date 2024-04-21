package com.finance_dock.finance_dock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String senha;

    @OneToOne(mappedBy = "usuario")
    private Dashboard dashboard;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void usuarioSetSenha(String senha, String repitaSenha) {
        if (!senha.equals(repitaSenha)) 
            throw new IllegalArgumentException("Senha e repetição de senha não conferem");
         else if(senha.length() < 8)
            throw new IllegalArgumentException("Senha deve ter no mínimo 8 caracteres");
        
        setSenha(senha);
    }
    
    public void trocarSenha(String senhaAtual, String novaSenha, String repitaNovaSenha) {
        if (senhaAtual.equals(this.senha)) 
            throw new IllegalArgumentException("Senha atual inválida");
        
        if (!novaSenha.equals(repitaNovaSenha)) 
            throw new IllegalArgumentException("Nova senha e repetição de senha não conferem");
         else if(novaSenha.length() < 8)
            throw new IllegalArgumentException("Senha deve ter no mínimo 8 caracteres");
        
        setSenha(novaSenha);
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
    }

}
