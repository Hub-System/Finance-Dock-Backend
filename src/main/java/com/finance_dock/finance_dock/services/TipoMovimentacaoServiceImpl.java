package com.finance_dock.finance_dock.services;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.TipoMovimentacaoDTO;
import com.finance_dock.finance_dock.models.TipoMovimentacao;
import com.finance_dock.finance_dock.repositories.TipoMovimentacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoMovimentacaoServiceImpl implements TipoMovimentacaoService {
    private final TipoMovimentacaoRepository tipoMovimentacaoRepository;
    @Override
    public void criarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao) {
        tipoMovimentacaoRepository.save(new TipoMovimentacao(
            0l,
            tipoMovimentacao.getNome()
        ));
    }

    @Override
    public TipoMovimentacaoDTO buscarTipoMovimentacao(Long id) {
        TipoMovimentacao tipoMovimentacaoEntity = tipoMovimentacaoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("tipo de movimentação não encontrada"));
        return converterParaDTO(tipoMovimentacaoEntity);
    }

    @Override
    public TipoMovimentacaoDTO atualizarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao) {
        TipoMovimentacao tipoMovimentacaoEntity = tipoMovimentacaoRepository.findById(tipoMovimentacao.getId())
        .orElseThrow(() -> new RuntimeException("tipo de movimentação não encontrada"));
        return converterParaDTO(tipoMovimentacaoEntity);
    }
    @Override
    public TipoMovimentacaoDTO converterParaDTO(TipoMovimentacao tipoMovimentacao) {
        return new TipoMovimentacaoDTO(
            tipoMovimentacao.getId(),
            tipoMovimentacao.getNome()
        );
    }

    @Override
    public TipoMovimentacao converterParaEntity(TipoMovimentacaoDTO tipoMovimentacao) {
        return new TipoMovimentacao(
            tipoMovimentacao.getId(),
            tipoMovimentacao.getNome()
        );
    }

    @Override
    public void deletarTipoMovimentacao(Long id) {
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("tipo de movimentação não encontrada"));
        tipoMovimentacaoRepository.delete(tipoMovimentacao);
    }
    
}
