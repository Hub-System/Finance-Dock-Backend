package com.finance_dock.finance_dock.services;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.TipoMovimentacao;
import com.finance_dock.finance_dock.repositories.EntradaRepository;
import com.finance_dock.finance_dock.repositories.TipoMovimentacaoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntradaServiceImpl implements EntradaService {
    EntradaRepository entradaRepository;
    TipoMovimentacaoRepository tipoMovimentacaoRepository;

    @Override
    @Transactional
    public void criarEntrada(EntradaDTO entrada) {
        Entrada entradaEntity = converterParaEntity(entrada);
        entradaRepository.save(entradaEntity);
    }

    @Override
    public EntradaDTO buscarEntrada(Long id) {
        return converterParaDTO(
            entradaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Entrada não encontrada")));
    }

    @Override
    @Transactional
    public void atualizarEntrada(EntradaDTO entrada) {
        Entrada entradaEntity = converterParaEntity(entrada);
        buscarEntrada(entrada.getId());
        entradaRepository.save(entradaEntity);
    }

    @Override
    public EntradaDTO converterParaDTO(Entrada entrada) {
        return new EntradaDTO(
            entrada.getDescricao(),
            entrada.getValor(),
            entrada.getInsercao(),
            entrada.getTipoMovimentacao().getId(),
            entrada.getDashboard().getId(),
            entrada.getId()
        );
    }

    @Override
    public Entrada converterParaEntity(EntradaDTO entrada) {
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoRepository.findById(
            entrada.getTipoMovimentacaoId()
        ).orElseThrow(() -> new RuntimeException("Tipo de movimentação não encontrada"));
        return new Entrada(
            entrada.getId(),
            entrada.getDescricao(),
            entrada.getValor(),
            entrada.getInsercao(),
            tipoMovimentacao
        );
    }
}
