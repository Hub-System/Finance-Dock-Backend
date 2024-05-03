package com.finance_dock.finance_dock.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDTO {
    private Long id;
    private List<EntradaDTO> entradas;
    private List<SaidaDTO> saidas;
    private double saldo;
    private double entradaTotal;
    private double saidaTotal;
    private Long idUsuario;
}
