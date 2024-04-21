package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.models.Saida;

public interface SaidaService {
    Saida criarSaida(SaidaDTO saida);
    Saida buscarSaida(Long id);
    Saida atualizarSaida(SaidaDTO saida);
    void deletarSaida(Long id);
}
