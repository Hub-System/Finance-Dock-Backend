package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
  private final UsuarioService usuarioService;

  @PostMapping
  public void criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    usuarioService.criarUsuario(usuarioDTO);
  }

  @GetMapping("/{id}")
  public UsuarioDTO buscarUsuario(@PathVariable Long id) {
    return usuarioService.buscarUsuario(id);
  }

  @PutMapping()
  public void atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    usuarioService.atualizarUsuario(usuarioDTO);
  }
}
