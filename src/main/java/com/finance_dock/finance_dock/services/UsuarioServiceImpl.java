package com.finance_dock.finance_dock.services;

import org.springframework.stereotype.Service;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional
    public void criarUsuario(UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setFirebaseId(usuario.getFirebaseId());
        usuarioRepository.save(novoUsuario);
    }

    @Override
    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getFirebaseId()
        );
    }

    @Override
    public UsuarioDTO logarUsuario(String firebaseId) {
        Usuario usuario = usuarioRepository.findByFirebaseId(firebaseId);
        if (usuario.getFirebaseId().isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getFirebaseId()
        );
    }
    
}
