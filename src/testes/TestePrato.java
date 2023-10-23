package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.GerenciarPrato;
import application.models.Ingrediente;
import application.models.Prato;

class TestePrato {

	@Test
	void testeConstrutorPrato() {

		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);

		assertEquals(prato, prato);

		prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes1, (float) 20.0);

		assertEquals(prato, prato);
	}

	@Test
	void testeCriacaoGerenciarPrato() {

		assertSame(0, GerenciarPrato.getPratos().size());
		assertSame(0, GerenciarPrato.getIdPratos());

	}

	@Test
	void testeAdicionarPrato() {

		List<Prato> pratosVazia = new ArrayList<>();

		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);
		Prato prato2 = new Prato("Feijoada", "almoco", "feijao e carne", ingredientes1, (float) 25.0);

		assertSame(0, GerenciarPrato.getPratos().size());

		GerenciarPrato.adicionarPrato(prato);

		assertSame(1, GerenciarPrato.getPratos().size());

		GerenciarPrato.adicionarPrato(prato2);

		assertSame(2, GerenciarPrato.getPratos().size());

		GerenciarPrato.setIdPratos(0);
		GerenciarPrato.setPratos(pratosVazia);

	}

	@Test
	void testeExcluirPrato() {

		List<Prato> pratosVazia = new ArrayList<>();

		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);
		Prato prato2 = new Prato("Feijoada", "almoco", "feijao e carne", ingredientes1, (float) 25.0);

		GerenciarPrato.adicionarPrato(prato);
		GerenciarPrato.adicionarPrato(prato2);

		assertSame(2, GerenciarPrato.getPratos().size());

		GerenciarPrato.excluirPrato(0);

		assertSame(1, GerenciarPrato.getPratos().size());

		GerenciarPrato.excluirPrato(1);

		assertSame(0, GerenciarPrato.getPratos().size());

		GerenciarPrato.setIdPratos(0);
		GerenciarPrato.setPratos(pratosVazia);
	}

	@Test
	void testeEditarPrato() {

		List<Prato> pratosVazia = new ArrayList<>();

		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);
		Prato prato2 = new Prato("Feijoada", "almoco", "feijao e carne", ingredientes1, (float) 25.0);
		prato2.setIdPrato(0);

		GerenciarPrato.adicionarPrato(prato);

		List<Prato> pratos = GerenciarPrato.getPratos();

		assertEquals(prato, pratos.get(0));

		GerenciarPrato.editarProduto(prato2);

		assertEquals(prato2, pratos.get(0));

		GerenciarPrato.setIdPratos(0);
		GerenciarPrato.setPratos(pratosVazia);

	}

	@Test
	void testeListagemPratos() {

		List<Prato> pratosVazia = new ArrayList<>();

		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);
		Prato prato2 = new Prato("Feijoada", "almoco", "feijao e carne", ingredientes1, (float) 25.0);

		GerenciarPrato.adicionarPrato(prato);
		GerenciarPrato.adicionarPrato(prato2);

		List<Prato> pratos = GerenciarPrato.getPratos();

		assertSame(2, GerenciarPrato.getPratos().size());

		assertEquals(prato, pratos.get(0));

		GerenciarPrato.excluirPrato(0);

		assertSame(1, GerenciarPrato.getPratos().size());

		assertEquals(prato2, pratos.get(0));

		GerenciarPrato.excluirPrato(1);

		assertSame(0, GerenciarPrato.getPratos().size());

		GerenciarPrato.setIdPratos(0);
		GerenciarPrato.setPratos(pratosVazia);
	}

}
