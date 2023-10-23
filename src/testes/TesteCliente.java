package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.Cliente;
import application.models.GerenciarCliente;

class TesteCliente {

	@Test
	void testeConstrutorCliente() {

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);

		assertEquals(cliente1, cliente1);
		assertEquals(cliente2, cliente2);

	}

	@Test
	void testeCriacaoGerenciarCliente() {

		assertSame(0, GerenciarCliente.getClientes().size());
		assertSame(0, GerenciarCliente.getIdClientes());

	}

	@Test
	void testeAdicionarCliente() {

		List<Cliente> clientesVazia = new ArrayList<>();

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);
		Cliente cliente3 = new Cliente("joao", 456, "@op", 789);

		assertSame(0, GerenciarCliente.getClientes().size());
		assertSame(0, GerenciarCliente.getIdClientes());

		GerenciarCliente.adicionarCliente(cliente1);

		assertSame(1,  GerenciarCliente.getClientes().size());
		assertSame(1, GerenciarCliente.getIdClientes());

		GerenciarCliente.adicionarCliente(cliente2);

		assertSame(2,  GerenciarCliente.getClientes().size());
		assertSame(2, GerenciarCliente.getIdClientes());

		GerenciarCliente.adicionarCliente(cliente3);

		assertSame(3,  GerenciarCliente.getClientes().size());
		assertSame(3, GerenciarCliente.getIdClientes());

		GerenciarCliente.setIdClientes(0);
		GerenciarCliente.setCliente(clientesVazia);

	}

	@Test
	void testeExcluirCliente() {

		List<Cliente> clientesVazia = new ArrayList<>();

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);
		Cliente cliente3 = new Cliente("joao", 456, "@op", 789);

		GerenciarCliente.adicionarCliente(cliente1); 
		GerenciarCliente.adicionarCliente(cliente2);
		GerenciarCliente.adicionarCliente(cliente3);

		assertSame(3, GerenciarCliente.getClientes().size());

		GerenciarCliente.excluirCliente(0);

		assertSame(2, GerenciarCliente.getClientes().size());

		GerenciarCliente.excluirCliente(1);

		assertSame(1, GerenciarCliente.getClientes().size());

		GerenciarCliente.excluirCliente(2);

		assertSame(0, GerenciarCliente.getClientes().size());

		GerenciarCliente.setIdClientes(0);
		GerenciarCliente.setCliente(clientesVazia);
	}

	@Test
	void testeEditarCliente() {

		List<Cliente> clientesVazia = new ArrayList<>();

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);
		
		cliente2.setIdCliente(0);

		GerenciarCliente.adicionarCliente(cliente1);

		List<Cliente> clientes = GerenciarCliente.getClientes();

		assertEquals(cliente1, clientes.get(0));

		GerenciarCliente.editarClientes(cliente2);

		assertEquals(cliente2, clientes.get(0));

		GerenciarCliente.setIdClientes(0);
		GerenciarCliente.setCliente(clientesVazia);
	}

	@Test
	void testeListagemClientes() {

		List<Cliente> clientesVazia = new ArrayList<>();

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);

		GerenciarCliente.adicionarCliente(cliente1);
		GerenciarCliente.adicionarCliente(cliente2);

		List<Cliente> clientes = GerenciarCliente.getClientes();

		assertSame(2, clientes.size());

		assertEquals(cliente1, clientes.get(0));

		GerenciarCliente.excluirCliente(0);

		assertSame(1, clientes.size());

		assertEquals(cliente2, clientes.get(0));

		GerenciarCliente.excluirCliente(1);

		assertSame(0, clientes.size());

		GerenciarCliente.setIdClientes(0);
		GerenciarCliente.setCliente(clientesVazia);

	}

}
