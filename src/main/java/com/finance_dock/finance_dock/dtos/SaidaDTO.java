package com.finance_dock.finance_dock.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaidaDTO {
    private Long id;
    private String descricao;
    private double valor;
    private String insercao;
    private Long tipoMovimentacaoId;
    private Long dashboardId;
}
