package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.models.Entrada;

public interface EntradaService {
    Entrada criarEntrada(EntradaDTO entrada);
    Entrada buscarEntrada(Long id);
    Entrada atualizarEntrada(EntradaDTO entrada);
    void deletarEntrada(Long id);
}
