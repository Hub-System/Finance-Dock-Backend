package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.services.EntradaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entradas")
public class EntradaController {
  private final EntradaService entradaService;

  @PostMapping
  public void criarEntrada(@RequestBody EntradaDTO entradaDTO) {
    entradaService.criarEntrada(entradaDTO);
  }

  @GetMapping("/{id}")
  public EntradaDTO buscarEntrada(@PathVariable Long id) {
    return entradaService.buscarEntrada(id);
  }

  @PutMapping()
  public void atualizarEntrada(@RequestBody EntradaDTO entradaDTO) {
    entradaService.atualizarEntrada(entradaDTO);
  }

  @DeleteMapping("/{id}")
  public void deletarEntrada(@PathVariable Long id) {
    entradaService.deletarEntrada(id);
  }
}
