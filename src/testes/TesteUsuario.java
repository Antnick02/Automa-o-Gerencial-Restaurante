package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.Funcionario;
import application.models.GerenciarUsuario;
import application.models.Gerente;
import application.models.Usuario;

class TesteUsuario {

	@Test
	void testeConstrutorUsuario() {

		Gerente gerente = new Gerente("joao", "123");
		Funcionario funcionario = new Funcionario("jorge", "321");

		assertEquals(gerente, gerente);
		assertEquals(funcionario, funcionario);

	}

	@Test
	void testeCriacaoGerenciarUsuario() {

		assertSame(0, GerenciarUsuario.getUsuarios().size());
		assertSame(0, GerenciarUsuario.getIdUsuarios());

	}

	@Test
	void testeAdicionarUsuario() {

		List<Usuario> usuariosVazia = new ArrayList<>();

		Gerente gerente1 = new Gerente("joao", "123");
		Funcionario funcionario = new Funcionario("jorge", "321");
		Gerente gerente2 = new Gerente("joaquim", "12");

		assertSame(0, GerenciarUsuario.getUsuarios().size());
		assertSame(0, GerenciarUsuario.getIdUsuarios());

		GerenciarUsuario.adicionarUsuario(gerente1);

		assertSame(1, GerenciarUsuario.getUsuarios().size());
		assertSame(1, GerenciarUsuario.getIdUsuarios());

		GerenciarUsuario.adicionarUsuario(funcionario);

		assertSame(2, GerenciarUsuario.getUsuarios().size());
		assertSame(2, GerenciarUsuario.getIdUsuarios());

		GerenciarUsuario.adicionarUsuario(gerente2);

		assertSame(3, GerenciarUsuario.getUsuarios().size());
		assertSame(3, GerenciarUsuario.getIdUsuarios());

		GerenciarUsuario.setIdUsuarios(0);
		GerenciarUsuario.setUsuarios(usuariosVazia);

	}

	@Test
	void testeExcluirUsuario() {

		List<Usuario> usuariosVazia = new ArrayList<>();

		Gerente gerente1 = new Gerente("joao", "123");
		Funcionario funcionario = new Funcionario("jorge", "321");
		Gerente gerente2 = new Gerente("joaquim", "12");

		GerenciarUsuario.adicionarUsuario(gerente1);
		GerenciarUsuario.adicionarUsuario(funcionario);
		GerenciarUsuario.adicionarUsuario(gerente2);

		assertSame(3, GerenciarUsuario.getUsuarios().size());

		GerenciarUsuario.excluirUsuario(0);

		assertSame(2, GerenciarUsuario.getUsuarios().size());

		GerenciarUsuario.excluirUsuario(1);

		assertSame(1, GerenciarUsuario.getUsuarios().size());

		GerenciarUsuario.excluirUsuario(2);

		assertSame(0, GerenciarUsuario.getUsuarios().size());

		GerenciarUsuario.setIdUsuarios(0);
		GerenciarUsuario.setUsuarios(usuariosVazia);
	}

	@Test
	void testeEditarUsuario() {

		List<Usuario> usuariosVazia = new ArrayList<>();

		Gerente gerente1 = new Gerente("joao", "123");
		Gerente gerente2 = new Gerente("joaquim", "12");
		gerente2.setIdUsuario(0);

		GerenciarUsuario.adicionarUsuario(gerente1);

		List<Usuario> usuarios = GerenciarUsuario.getUsuarios();

		assertEquals(gerente1, usuarios.get(0));

		GerenciarUsuario.editarUsuario(gerente2);

		assertEquals(gerente2, usuarios.get(0));

		GerenciarUsuario.setIdUsuarios(0);
		GerenciarUsuario.setUsuarios(usuariosVazia);
	}

	@Test
	void testeListagemProdutos() {

		List<Usuario> usuariosVazia = new ArrayList<>();

		Gerente gerente = new Gerente("joao", "123");
		Funcionario funcionario = new Funcionario("jorge", "321");

		GerenciarUsuario.adicionarUsuario(funcionario);
		GerenciarUsuario.adicionarUsuario(gerente);

		List<Usuario> usuarios = GerenciarUsuario.getUsuarios();

		assertSame(2, usuarios.size());

		assertEquals(funcionario, usuarios.get(0));

		GerenciarUsuario.excluirUsuario(0);

		assertSame(1, usuarios.size());

		assertEquals(gerente, usuarios.get(0));

		GerenciarUsuario.excluirUsuario(1);

		assertSame(0, usuarios.size());

		GerenciarUsuario.setIdUsuarios(0);
		GerenciarUsuario.setUsuarios(usuariosVazia);

	}
}
