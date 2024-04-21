package com.finance_dock.finance_dock.dtos;

import java.util.List;

import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.Saida;
import com.finance_dock.finance_dock.models.Usuario;

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
    private Long usuarioId;
}
