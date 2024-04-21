package com.finance_dock.finance_dock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finance_dock.finance_dock.models.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{
    @Query("SELECT s FROM Saida s WHERE s.dashboard.id = ?1")
    List<Saida> findAllByDashbordId(Long dashboardId);
}
