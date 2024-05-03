package com.finance_dock.finance_dock.dtos;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoMovimentacaoDTO {
    private Optional<Long> id;
    private String descricao;
    private String tipo;
}
