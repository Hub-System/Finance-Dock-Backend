package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Saida;

public interface SaidaService {
    SaidaDTO criarSaida(SaidaDTO saida);
    SaidaDTO buscarSaida(Long id);
    SaidaDTO atualizarSaida(SaidaDTO saida);
    SaidaDTO converterParaDTO(Saida saida);
    Saida converterParaEntity(SaidaDTO saida);
}
