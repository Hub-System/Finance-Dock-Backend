package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.models.Entrada;

public interface EntradaService {
    void criarEntrada(EntradaDTO entrada);
    EntradaDTO buscarEntrada(Long id);
    void atualizarEntrada(EntradaDTO entrada);
    EntradaDTO converterParaDTO(Entrada entrada);
    Entrada converterParaEntity(EntradaDTO entrada);
}
