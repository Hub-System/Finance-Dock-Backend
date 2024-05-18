package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;

public interface UsuarioService {
    void criarUsuario(UsuarioDTO usuario);
    UsuarioDTO buscarUsuario(Long id);
    UsuarioDTO logarUsuario(String firebaseId);
}
