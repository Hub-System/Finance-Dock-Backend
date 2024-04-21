package com.finance_dock.finance_dock.dtos;

import java.util.Date;

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
    private Date vencimento;
    private Long tipoMovimentacaoId;
    private Long dashboardId;
}
