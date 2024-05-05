package com.finance_dock.finance_dock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dock.finance_dock.dtos.TipoMovimentacaoDTO;
import com.finance_dock.finance_dock.services.TipoMovimentacaoService;

@RestController
@RequestMapping("/tipoMovimentacao")
public class TipoMovimentacaoController {

  @Autowired
  private TipoMovimentacaoService tipoMovimentacaoService;

  @PostMapping
  public void criarTipoMovimentacao(@RequestBody TipoMovimentacaoDTO tipoMovimentacaoDTO) {
    tipoMovimentacaoService.criarTipoMovimentacao(tipoMovimentacaoDTO);
  }

  @GetMapping("/{id}")
  public TipoMovimentacaoDTO buscarTipoMovimentacao(@PathVariable Long id) {
    return tipoMovimentacaoService.buscarTipoMovimentacao(id);
  }

  @PostMapping("/{id}")
  public void atualizarTipoMovimentacao(@RequestBody TipoMovimentacaoDTO tipoMovimentacaoDTO) {
    tipoMovimentacaoService.atualizarTipoMovimentacao(tipoMovimentacaoDTO);
  }
}
