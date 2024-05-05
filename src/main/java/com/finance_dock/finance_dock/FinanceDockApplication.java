package com.finance_dock.finance_dock;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.finance_dock.finance_dock.models.Dashboard;
import com.finance_dock.finance_dock.models.Entrada;
import com.finance_dock.finance_dock.models.Saida;
import com.finance_dock.finance_dock.models.TipoMovimentacao;
import com.finance_dock.finance_dock.models.Usuario;
import com.finance_dock.finance_dock.repositories.DashBoardRepository;
import com.finance_dock.finance_dock.repositories.EntradaRepository;
import com.finance_dock.finance_dock.repositories.SaidaRepository;
import com.finance_dock.finance_dock.repositories.TipoMovimentacaoRepository;
import com.finance_dock.finance_dock.repositories.UsuarioRepository;

@SpringBootApplication
public class FinanceDockApplication {
	// @Bean
	// CommandLineRunner runner(@Autowired DashBoardRepository DashBoardRepository,
	// @Autowired UsuarioRepository usuarioRepository,
	// @Autowired EntradaRepository entradaRepository,
	// @Autowired SaidaRepository saidaRepository,
	// @Autowired TipoMovimentacaoRepository tipoMovimentacaoRepository) {
	// return args -> {
	// List<TipoMovimentacao> tipos = List.of(
	// new TipoMovimentacao(0l, "tipo1"),
	// new TipoMovimentacao(0l, "tipo2"),
	// new TipoMovimentacao(0l, "tipo3")
	// );

	// tipos.forEach(tipo -> tipoMovimentacaoRepository.save(tipo));
	// List<TipoMovimentacao> allTipos = tipoMovimentacaoRepository.findAll();
	// List<Entrada> entradas = List.of(
	// new Entrada(0l, "descricao1", 100.0, new Date(), allTipos.get(0)),
	// new Entrada(0l, "descricao2", 200.0, new Date(), allTipos.get(1)),
	// new Entrada(0l, "descricao3", 300.0, new Date(), allTipos.get(2))
	// );
	// List<Saida> saidas = List.of(
	// new Saida(0l, "descricao1", new Date(), 100.0, allTipos.get(0)),
	// new Saida(0l, "descricao2", new Date(), 200.0, allTipos.get(1)),
	// new Saida(0l, "descricao3", new Date(), 300.0, allTipos.get(2))
	// );

	// entradas.forEach(entrada -> entradaRepository.save(entrada));
	// saidas.forEach(saida -> saidaRepository.save(saida));
	// Usuario user1 = new Usuario(0l, "nome", "email", "senha");
	// Usuario user2 = new Usuario(0l, "nome1", "email1", "senha1");
	// usuarioRepository.save(user1);
	// usuarioRepository.save(user2);
	// List<Usuario> allUsers = usuarioRepository.findAll();
	// Usuario userRep1 = allUsers.get(0);
	// Usuario userRep2 = allUsers.get(1);
	// DashBoardRepository.save(new Dashboard(0l, userRep1));
	// DashBoardRepository.save(new Dashboard(0l, userRep2));
	// System.out.println("Usuários e Dashboards criados");
	// // System.out.println(DashBoardRepository.findById(1l));
	// // DashBoardRepository.findAll().forEach(System.out::println);
	// allUsers.forEach(System.out::println);
	// // System.out.println(usuarioRepository.findById(1l).);;
	// allTipos.forEach(System.out::println);
	// entradaRepository.findAll().forEach(System.out::println);
	// saidaRepository.findAll().forEach(System.out::println);
	// };
	// }
	public static void main(String[] args) {
		SpringApplication.run(FinanceDockApplication.class, args);
	}

}
