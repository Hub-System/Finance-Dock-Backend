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
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(usuario.getSenha());
        usuarioRepository.save(novoUsuario);
    }

    @Override
    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return converterParaDTO(usuario);
    }

    @Override
    @Transactional
    public void atualizarUsuario(UsuarioDTO usuario) {
        usuarioRepository.findById(usuario.getId())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = converterParaEntity(usuario);
        usuarioRepository.save(usuarioAtualizado);
    }

    @Override
    public void logarUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuario.getId() == null) {
            throw new IllegalArgumentException("Usuário/Senha não encontrados");
        }
    }

    @Override
    public UsuarioDTO converterParaDTO(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha()
        );
    }

    @Override
    public Usuario converterParaEntity(UsuarioDTO usuario) {
        return new Usuario(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha()
        );
    }
    
}
