package com.finance_dock.finance_dock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.DashboardDTO;
import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.Saida;
import com.finance_dock.finance_dock.models.TipoMovimentacao;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.EntradaRepository;
import com.finance_dock.finance_dock.repositories.SaidaRepository;
import com.finance_dock.finance_dock.repositories.TipoMovimentacaoRepository;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private final UsuarioRepository usuarioRepository;
    private final DashBoardRepository dashBoardRepository;
    private final EntradaRepository entradaRepository;
    private final SaidaRepository saidaRepository;
    private final TipoMovimentacaoRepository tipoMovimentacaoRepository;
    
    @Transactional
    @Override
    public Dashboard criarDashboard(DashboardDTO dashboardDTO) {
        Usuario usuario = usuarioRepository.findById(dashboardDTO.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Dashboard dashboard = new Dashboard();
        dashboard.setUsuario(usuario);        
        return dashboard;
    }

    @Override
    public Dashboard buscarDashboard(Long id) {
        return dashBoardRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dashbord não encontrada"));
    }

    @Transactional
    @Override
    public Dashboard atualizarDashboard(DashboardDTO dashboard) {
        List<Entrada> entradas = null;
        List<Saida> saidas = null;
        Usuario usuario = usuarioRepository.findById(dashboard.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        dashboard.getEntradas().forEach(entrada -> {
            entradaRepository.findById(entrada.getId())
                .orElseThrow(() -> new RuntimeException("Entrada não encontrada"));

            TipoMovimentacao tipoMovimentacaoEntrada = 
            tipoMovimentacaoRepository.findById(entrada.getTipoMovimentacaoId())
            .orElseThrow(() -> new RuntimeException("Tipo de movimentação não encontrado"));
            entradas.add(
                new Entrada(
                entrada.getId(), 
                entrada.getDescricao(), 
                entrada.getValor(), 
                entrada.getInsercao(), 
                tipoMovimentacaoEntrada)
            );
        });
        dashboard.getSaidas().forEach(saida -> {
            saidaRepository.findById(saida.getId())
                .orElseThrow(() -> new RuntimeException("Saida não encontrada"));

            TipoMovimentacao tipoMovimentacaoSaida = 
            tipoMovimentacaoRepository.findById(saida.getTipoMovimentacaoId())
            .orElseThrow(() -> new RuntimeException("Tipo de movimentação não encontrado"));
            saidas.add(
                new Saida(
                saida.getId(), 
                saida.getDescricao(), 
                saida.getValor(), 
                saida.getVencimento(), 
                tipoMovimentacaoSaida)
            );
        });
        Dashboard dash = new Dashboard(
            dashboard.getId(), 
            usuario
        );
        dash.setEntradas(entradas);
        dash.setSaidas(saidas);
        dashBoardRepository.save(dash);
        return dash;
    }

    @Transactional
    @Override
    public void deletarDashboard(Long id) {
        dashBoardRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dashbord não encontrada"));
        dashBoardRepository.deleteById(id);
    }
    
}
