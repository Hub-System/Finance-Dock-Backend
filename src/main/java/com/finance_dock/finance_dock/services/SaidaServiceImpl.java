package com.finance_dock.finance_dock.services;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Saida;
import com.finance_dock.finance_dock.models.TipoMovimentacao;
import com.finance_dock.finance_dock.repositories.SaidaRepository;
import com.finance_dock.finance_dock.repositories.TipoMovimentacaoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaidaServiceImpl implements SaidaService {
    private final TipoMovimentacaoRepository tipoMovimentacaoRepository;
    private final SaidaRepository saidaRepository;

    @Override
    @Transactional 
    public void criarSaida(SaidaDTO saida) {
        saidaRepository.save(
            converterParaEntity(saida)
        );
    }

    @Override
    public SaidaDTO buscarSaida(Long id) {
        return converterParaDTO(
            saidaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Saida não encontrada")));
    }

    @Override
    public void atualizarSaida(SaidaDTO saida) {
        buscarSaida(saida.getId());
        criarSaida(saida);
    }

    @Override
    public SaidaDTO converterParaDTO(Saida saida) {
        return new SaidaDTO(
            saida.getDescricao(),
            saida.getValor(),
            saida.getVencimento(),
            saida.getTipoMovimentacao().getId(),
            saida.getDashboard().getId(),
            saida.getId()
        );
    }

    @Override
    public Saida converterParaEntity(SaidaDTO saida) {
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoRepository.findById(
            saida.getTipoMovimentacaoId()
        ).orElseThrow(() -> new RuntimeException("Tipo de movimentação não encontrada"));
        return new Saida(
            saida.getId(),
            saida.getDescricao(),
            saida.getValor(),
            saida.getVencimento(),
            tipoMovimentacao
        );
    }
    
}
