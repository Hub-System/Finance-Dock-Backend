package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.TipoMovimentacaoDTO;
import com.finance_dock.finance_dock.models.TipoMovimentacao;

public interface TipoMovimentacaoService {
    void criarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao);
    TipoMovimentacaoDTO buscarTipoMovimentacao(Long id);
    TipoMovimentacaoDTO atualizarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao);
    TipoMovimentacaoDTO converterParaDTO(TipoMovimentacao tipoMovimentacao);
    TipoMovimentacao converterParaEntity(TipoMovimentacaoDTO tipoMovimentacao);
    void deletarTipoMovimentacao(Long id);
}
