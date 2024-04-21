package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.models.Usuario;

public interface UsuarioService {
    Usuario criarUsuario(UsuarioDTO usuario);
    Usuario buscarUsuario(Long id);
    Usuario atualizarUsuario(UsuarioDTO usuario);
    Usuario logarUsuario(String email, String senha);
    void deletarUsuario(Long id);
}
