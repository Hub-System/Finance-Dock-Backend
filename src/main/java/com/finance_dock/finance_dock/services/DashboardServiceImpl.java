package com.finance_dock.finance_dock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.EntradaRepository;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private final UsuarioRepository usuarioRepository;
    private final EntradaRepository entradaRepository;
    @Override
    public Dashboard criarDashboard(DashboardDTO dashboardDTO) {
        Usuario usuario = usuarioRepository.findById(dashboardDTO.getUsuarioID())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Dashboard dashboard = new Dashboard();
        dashboard.setUsuario(usuario);        
        return dashboard;
    }

    @Override
    public Dashboard buscarDashboard(Long id) {
        Dashboard dashboard;
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        
        List<Entrada> entradas = entradaRepository.findByUsuario(usuario);
        return dashboard;
    }

    @Override
    public Dashboard atualizarDashboard(DashboardDTO dashboard) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarDashboard'");
    }

    @Override
    public void deletarDashboard(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarDashboard'");
    }
    
}
