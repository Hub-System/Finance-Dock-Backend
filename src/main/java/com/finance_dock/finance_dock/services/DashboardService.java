package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.models.Dashboard;

public interface DashboardService {
    DashboardDTO criarDashboard(DashboardDTO dashboard);
    DashboardDTO buscarDashboard(Long id);
    void atualizarDashboard(DashboardDTO dashboard);
    DashboardDTO converterParaDTO(Dashboard dashboard);
    Dashboard converterParaEntity(DashboardDTO dashboard);
}
