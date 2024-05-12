package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.SaidaDTO;
import com.finance_dock.finance_dock.services.SaidaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/saidas")
public class SaidaController {
  private final SaidaService saidaService;

  @PostMapping
  public void criarSaida(@RequestBody SaidaDTO saidaDTO) {
    saidaService.criarSaida(saidaDTO);
  }

  @GetMapping("/{id}")
  public SaidaDTO buscarSaida(@PathVariable Long id) {
    return saidaService.buscarSaida(id);
  }

  @PutMapping()
  public void atualizarSaida(@RequestBody SaidaDTO saidaDTO) {
    saidaService.atualizarSaida(saidaDTO);
  }
}
