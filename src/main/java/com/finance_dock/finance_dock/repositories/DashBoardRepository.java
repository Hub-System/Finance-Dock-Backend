package com.finance_dock.finance_dock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance_dock.finance_dock.models.Dashboard;


public interface DashBoardRepository extends JpaRepository<Dashboard, Long>{
    @Query("select dd from Dashboard dd left join fetch dd.entradas e left join fetch dd.saidas s where dd.id = :id")
    Dashboard findDashboardFetchEntradasAndSaidas(@Param("id") Long id);
    Dashboard findByFirebaseId(String firebaseId);
}
