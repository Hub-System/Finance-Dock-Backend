package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.models.Dashboard;

public interface DashboardService {
    Dashboard criarDashboard(DashboardDTO dashboard);
    Dashboard buscarDashboard(Long id);
    Dashboard atualizarDashboard(DashboardDTO dashboard);
    void deletarDashboard(Long id);
}
