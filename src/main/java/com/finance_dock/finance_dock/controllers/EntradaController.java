package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.EntradaDTO;
import com.finance_dock.finance_dock.services.EntradaService;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

  @Autowired
  private EntradaService entradaService;

  @PostMapping
  public void criarEntrada(@RequestBody EntradaDTO entradaDTO) {
    entradaService.criarEntrada(entradaDTO);
  }

  @GetMapping("/{id}")
  public EntradaDTO buscarEntrada(@PathVariable Long id) {
    return entradaService.buscarEntrada(id);
  }

  @PostMapping("/{id}")
  public void atualizarEntrada(@RequestBody EntradaDTO entradaDTO) {
    entradaService.atualizarEntrada(entradaDTO);
  }


}