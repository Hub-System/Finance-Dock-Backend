package com.finance_dock.finance_dock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance_dock.finance_dock.models.TipoMovimentacao;

public interface TipoMovimentacaoRepository extends JpaRepository<TipoMovimentacao, Long>{
    
}
