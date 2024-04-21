package com.finance_dock.finance_dock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance_dock.finance_dock.models.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{
    
}
