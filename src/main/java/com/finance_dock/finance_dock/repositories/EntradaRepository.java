package com.finance_dock.finance_dock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance_dock.finance_dock.models.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{
    
}
