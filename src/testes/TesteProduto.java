package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.GerenciarProduto;
import application.models.Produto;

class TesteProduto {

	@Test
	void testeConstrutorProduto() {

		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);


		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		

		assertEquals(produto1, produto1);

	}

	@Test
	void testeCriacaoGerenciarProduto() {

		assertSame(0, GerenciarProduto.getProdutos().size());
		assertSame(0, GerenciarProduto.getIdProdutos());

	}

	@Test
	void testeAdicionarProduto() {
		
		List<Produto>produtosVazia = new ArrayList<>();
		
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);

		String data132;
		Calendar data14 = Calendar.getInstance();
		data14.add(Calendar.DATE, 1);
		Date data3 = data14.getTime();
		data132 = s.format(data3);

		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		Produto produto2 = new Produto((float) 5.20, data321, "Saco de bala", 7000);
		Produto produto3 = new Produto((float) 7.30, data132, "macarrao", 10000);

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);

		assertEquals(0, GerenciarProduto.getIdProdutos());
		GerenciarProduto.adicionarProduto(produto1);
		List<Produto> produtos = GerenciarProduto.getProdutos();

		assertEquals(1, produtos.size());
		assertEquals(0, produtos.get(0).getIdProduto());
		assertEquals(1, GerenciarProduto.getIdProdutos());

		GerenciarProduto.adicionarProduto(produto2);
		assertSame(2, produtos.size());
		assertSame(1, produtos.get(1).getIdProduto());
		assertSame(2, GerenciarProduto.getIdProdutos());

		GerenciarProduto.adicionarProduto(produto3);
		assertSame(3, produtos.size());
		assertSame(2, produtos.get(2).getIdProduto());
		assertSame(3, GerenciarProduto.getIdProdutos());

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);
	}

	@Test
	void testeExcluirProduto() {
		
		List<Produto>produtosVazia = new ArrayList<>(); 
		
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);

		String data132;
		Calendar data14 = Calendar.getInstance();
		data14.add(Calendar.DATE, 1);
		Date data3 = data14.getTime();
		data132 = s.format(data3);

		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		Produto produto2 = new Produto((float) 5.20, data321, "Saco de bala", 7000);
		Produto produto3 = new Produto((float) 7.30, data132, "macarrao", 10000);

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);

		List<Produto> produtos = GerenciarProduto.getProdutos();

		GerenciarProduto.adicionarProduto(produto1);
		GerenciarProduto.adicionarProduto(produto2);
		GerenciarProduto.adicionarProduto(produto3);

		assertSame(3, GerenciarProduto.getProdutos().size());

		GerenciarProduto.excluirProduto(0);

		assertSame(2, produtos.size());

		GerenciarProduto.excluirProduto(0);

		assertSame(2, produtos.size());

		GerenciarProduto.excluirProduto(1);

		assertSame(1, produtos.size());

		GerenciarProduto.excluirProduto(2);

		assertSame(0, produtos.size());

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);
	}

	@Test
	void testeEditarProduto() {
		
		List<Produto>produtosVazia = new ArrayList<>(); 
		
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);


		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		Produto produto2 = new Produto((float) 5.20, data321, "Saco de bala", 7000);
		
		produto2.setIdProduto(0);

		GerenciarProduto.adicionarProduto(produto1);

		List<Produto> produtos = GerenciarProduto.getProdutos();

		assertEquals(produto1, produtos.get(0));

		GerenciarProduto.editarProduto(produto2);

		assertEquals(produto2, produtos.get(0));

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);
	}

	@Test
	void testeListagemProdutos() {
		 
		List<Produto>produtosVazia = new ArrayList<>();  
		
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);


		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		Produto produto2 = new Produto((float) 5.20, data321, "Saco de bala", 7000);

		GerenciarProduto.adicionarProduto(produto1);
		GerenciarProduto.adicionarProduto(produto2);

		List<Produto> produtos = GerenciarProduto.getProdutos();

		assertSame(2, produtos.size());

		assertEquals(produto1, produtos.get(0));

		GerenciarProduto.excluirProduto(0);
		;

		assertSame(1, produtos.size());

		assertEquals(produto2, produtos.get(0));

		GerenciarProduto.setIdProdutos(0);
		GerenciarProduto.setProdutos(produtosVazia);

	}

}
