package com.finance_dock.finance_dock.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Long dashboardId;
}
