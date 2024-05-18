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
    private String firebaseId;

    @OneToOne(mappedBy = "usuario")
    private Dashboard dashboard;

    public Usuario(Long id, String firebaseId, Dashboard dashboard) {
        this.id = id;
        this.firebaseId = firebaseId;
        this.dashboard = dashboard;
    }

    public Usuario() {
    }

    public Usuario(Long id, String firebaseId) {
        this.id = id;
        this.firebaseId = firebaseId;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirebaseId() {
        return firebaseId;
    }
    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", firebaseId=" + firebaseId + "]";
    }

}
