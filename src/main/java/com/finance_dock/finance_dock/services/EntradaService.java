package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.models.Entrada;

public interface EntradaService {
    EntradaDTO criarEntrada(EntradaDTO entrada);
    EntradaDTO buscarEntrada(Long id);
    EntradaDTO atualizarEntrada(EntradaDTO entrada);
    EntradaDTO converterParaDTO(Entrada entrada);
    Entrada converterParaEntity(EntradaDTO entrada);
}
