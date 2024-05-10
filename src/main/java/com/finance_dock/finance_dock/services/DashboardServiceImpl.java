package com.finance_dock.finance_dock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private final UsuarioRepository usuarioRepository;
    private final DashBoardRepository dashBoardRepository;
    
    @Transactional
    @Override
    public DashboardDTO criarDashboard(DashboardDTO dashboardDTO) {
        Usuario usuario = usuarioRepository.findById(dashboardDTO.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Dashboard dashboard = new Dashboard();
        dashboard.setUsuario(usuario);
        dashBoardRepository.save(dashboard);     
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
        usuarioRepository.findById(dashboard.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Dashboard dash = converterParaEntity(dashboard);
        dashBoardRepository.save(dash);
    }

    @Override
    public DashboardDTO converterParaDTO(Dashboard dashboard) {
        List<EntradaDTO> entradasDTO = null;
        List<SaidaDTO> saidasDTO = null;

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
                v -> saidasDTO.add(
                        new SaidaDTO(
                            v.getDescricao(),
                            v.getValor(),
                            v.getVencimento(),
                            v.getTipoMovimentacao().getId(),
                            v.getDashboard().getId(),
                            v.getId()
                        )
                    )
            );
        }

        return new DashboardDTO(
                    dashboard.getId(),
                    entradasDTO, 
                    saidasDTO, 
                    dashboard.getSaldo(), 
                    dashboard.getSaldoEntradas(), 
                    dashboard.getSaldoSaidas(), 
                    dashboard.getUsuario().getId());
    }

    @Override
    public Dashboard converterParaEntity(DashboardDTO dashboard) {
        return dashBoardRepository.findById(dashboard.getId())
        .orElseThrow(() -> new RuntimeException("Dashboard não encontrado"));
    }

}
