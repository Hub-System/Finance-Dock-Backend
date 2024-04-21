package com.finance_dock.finance_dock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finance_dock.finance_dock.models.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{
    @Query("SELECT e FROM Entrada e WHERE e.dashboard.id = ?1")
    List<Entrada> findAllByDashbordId(Long dashboardId);
}
