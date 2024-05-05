package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

  @Autowired
  private DashboardService dashboardService;

  @PostMapping
  public void criarDashboard(@RequestBody DashboardDTO dashboardDTO) {
    dashboardService.criarDashboard(dashboardDTO);
  }

  @GetMapping("/{id}")
  public DashboardDTO buscarDashboard(@PathVariable Long id) {
    return dashboardService.buscarDashboard(id);
  }

  @PostMapping("/{id}")
  public void atualizarDashboard(@RequestBody DashboardDTO dashboardDTO) {
    dashboardService.atualizarDashboard(dashboardDTO);
  }

}
