package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.TipoMovimentacaoDTO;
import com.finance_dock.finance_dock.models.TipoMovimentacao;

public interface TipoMovimentacaoService {
    TipoMovimentacao criarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao);
    TipoMovimentacao buscarTipoMovimentacao(Long id);
    TipoMovimentacao atualizarTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao);
    void deletarTipoMovimentacao(Long id);
}
