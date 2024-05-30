package com.finance_dock.finance_dock.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.Saida;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.EntradaRepository;
import com.finance_dock.finance_dock.repositories.SaidaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private final DashBoardRepository dashBoardRepository;
    private final EntradaServiceImpl entradaService;
    private final SaidaServiceImpl saidaService;
    
    @Transactional
    @Override
    public DashboardDTO criarDashboard(DashboardDTO dashboardDTO) {
        Dashboard dashboard = converterParaEntity(dashboardDTO);
        dashboard = dashBoardRepository.save(dashboard);     
        return converterParaDTO(dashboard);
    }

    @Override
    public DashboardDTO buscarDashboard(Long id) {
        Dashboard dashboard = dashBoardRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dashbord não encontrada"));
        return converterParaDTO(dashboard);
    }

    @Transactional
    @Override
    public void atualizarDashboard(DashboardDTO dashboard) {
        Dashboard dash = converterParaEntity(dashboard);
        dashBoardRepository.save(dash);
    }

    @Override
    public DashboardDTO converterParaDTO(Dashboard dashboard) {
        List<EntradaDTO> entradasDTO = new ArrayList<>();
        List<SaidaDTO> saidasDTO = new ArrayList<>();

        if (dashboard.getEntradas() != null) {
            dashboard.getEntradas().forEach(
                v -> entradasDTO.add(
                        new EntradaDTO(
                            v.getDescricao(),
                            v.getValor(),
                            v.getInsercao(),
                            v.getTipoMovimentacao().getId(),
                            v.getDashboard().getId(),
                            v.getId()
                        )
                    )
                
            );
        }

        if (dashboard.getSaidas() != null) {
            dashboard.getSaidas().forEach(
                v -> {
                    if (v.getId() != null){
                        saidasDTO.add(
                            new SaidaDTO(
                                v.getDescricao(),
                                v.getValor(),
                                v.getVencimento(),
                                v.getTipoMovimentacao().getId(),
                                v.getDashboard().getId(),
                                v.getId()
                            )
                        );
                }}
            );
        }

        return new DashboardDTO(
                    dashboard.getId(),
                    entradasDTO, 
                    saidasDTO, 
                    dashboard.getSaldo(), 
                    dashboard.getSaldoEntradas(), 
                    dashboard.getSaldoSaidas(), 
                    dashboard.getFirebaseId());
    }

    @Override
    public Dashboard converterParaEntity(DashboardDTO dashboard) {
        List<Entrada> entradas = new ArrayList<>();
        List<Saida> saidas = new ArrayList<>();

         if (dashboard.getEntradas().size() > 0) {
            dashboard.getEntradas().forEach(entrada -> {
                entradas.add(entradaService.converterParaEntity(entrada));
            });
        }

        if (dashboard.getSaidas().size() > 0) {
            dashboard.getSaidas().forEach(saida -> {
                saidas.add(saidaService.converterParaEntity(saida));
            });
        }
    
        return new Dashboard(
            dashboard.getId(),
            entradas,
            saidas,
            dashboard.getFirebaseId()
        );
    }

    @Override
    public DashboardDTO buscarDashboardFirebaseId(String firebaseId) {
        DashboardDTO dashboardDTO = converterParaDTO(dashBoardRepository.findByFirebaseId(firebaseId));
        if (dashboardDTO.getFirebaseId().isEmpty()) {
            throw new IllegalArgumentException("Não foi encontrado dashboard para este usuario");
        }
        return dashboardDTO;
    }

}
