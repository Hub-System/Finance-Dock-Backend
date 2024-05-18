package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.models.Usuario;

public interface UsuarioService {
    void criarUsuario(UsuarioDTO usuario);
    UsuarioDTO buscarUsuario(Long id);
    void atualizarUsuario(UsuarioDTO usuario);
    UsuarioDTO logarUsuario(String email, String senha);
    UsuarioDTO converterParaDTO(Usuario usuario);
    Usuario converterParaEntity(UsuarioDTO usuario);
}
