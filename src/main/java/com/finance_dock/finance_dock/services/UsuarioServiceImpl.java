package com.finance_dock.finance_dock.services;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

public class UsuarioServiceImpl implements UsuarioService{
    UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional
    public Usuario criarUsuario(UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(usuario.getSenha());
        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Override
    @Transactional
    public Usuario atualizarUsuario(UsuarioDTO usuario) {
        Usuario usuarioAtualizado = usuarioRepository.findById(usuario.getId())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());
        
        return usuarioRepository.save(usuarioAtualizado);
    }

    @Override
    public Usuario logarUsuario(String email, String senha) {
        try {
            return usuarioRepository.findByEmailAndSenha(email, senha);
        } catch (Exception e) {
            System.out.println(e + e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }
    
}
