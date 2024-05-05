package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.UsuarioDTO;
import com.finance_dock.finance_dock.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public void criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    usuarioService.criarUsuario(usuarioDTO);
  }

  @GetMapping("/{id}")
  public UsuarioDTO buscarUsuario(@PathVariable Long id) {
    return usuarioService.buscarUsuario(id);
  }

  @PostMapping("/{id}")
  public void atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    usuarioService.atualizarUsuario(usuarioDTO);
  }
}
