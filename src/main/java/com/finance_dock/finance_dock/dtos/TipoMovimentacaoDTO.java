package com.finance_dock.finance_dock.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoMovimentacaoDTO {
    private Long id;
    private String nome;
}
