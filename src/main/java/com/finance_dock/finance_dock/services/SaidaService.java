package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Saida;

public interface SaidaService {
    void criarSaida(SaidaDTO saida);
    SaidaDTO buscarSaida(Long id);
    void atualizarSaida(SaidaDTO saida);
    SaidaDTO converterParaDTO(Saida saida);
    Saida converterParaEntity(SaidaDTO saida);
}
