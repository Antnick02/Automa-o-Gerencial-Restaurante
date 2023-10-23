package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.GerenciarVenda;
import application.models.Venda;

class TesteVenda {

	@Test
	void testeConstrutorVenda() {


		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String data132;
		Calendar data14 = Calendar.getInstance();
		data14.add(Calendar.DATE, 1);
		Date data3 = data14.getTime();
		data132 = s.format(data3); 
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		
		
		assertEquals(venda, venda);
		
		venda = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		
		assertEquals(venda, venda);
	}
	
	@Test
	void testeCriacaoGerenciaVenda() {
		
		assertSame(0, GerenciarVenda.getVendas().size()); 
		assertSame(0, GerenciarVenda.getIdVendas()); 
		
	}
	
	@Test 
	void testeAdicionarVenda() {
		
		List<Venda> vendasVazia = new ArrayList<>();
		
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
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda1 = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		Venda venda2 = new Venda(data321, (float)25, itens1, "Pix", 2);
		
		
		assertSame(0, GerenciarVenda.getVendas().size()); 
		
		GerenciarVenda.adicionarVenda(venda1);
		
		assertSame(1, GerenciarVenda.getVendas().size());
		
		GerenciarVenda.adicionarVenda(venda2); 
		
		assertSame(2, GerenciarVenda.getVendas().size());
		
		GerenciarVenda.setIdVendas(0);
		GerenciarVenda.setVendas(vendasVazia);
		
	}
	
	@Test 
	void testeExcluirVenda() {
		
		List<Venda> vendasVazia = new ArrayList<>();
		
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
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda1 = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		Venda venda2 = new Venda(data321, (float)25, itens1, "Pix", 2);
		
		GerenciarVenda.adicionarVenda(venda1);
		GerenciarVenda.adicionarVenda(venda2); 
		
		assertSame(2, GerenciarVenda.getVendas().size()); 
		
		GerenciarVenda.excluirVenda(0); 
		
		assertSame(1, GerenciarVenda.getVendas().size());
		
		GerenciarVenda.excluirVenda(1);
		
		assertSame(0, GerenciarVenda.getVendas().size());
		
		GerenciarVenda.setIdVendas(0);
		GerenciarVenda.setVendas(vendasVazia);
	}
	
	@Test 
	void testeEditarVenda() {
		
		List<Venda> vendasVazia = new ArrayList<>();
		
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
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda1 = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		Venda venda2 = new Venda(data321, (float)25, itens1, "Pix", 2);
		venda2.setIdVenda(0);
		
		GerenciarVenda.adicionarVenda(venda1); 
		
		List<Venda>vendas = GerenciarVenda.getVendas(); 
		
		assertEquals(venda1, vendas.get(0)); 
		
		GerenciarVenda.editarVenda(venda2); 
		
		assertEquals(venda2, vendas.get(0));
		
		GerenciarVenda.setIdVendas(0);
		GerenciarVenda.setVendas(vendasVazia);
		
	}
	
	@Test 
	void testeListagemVendas() {
		
		List<Venda> vendasVazia = new ArrayList<>();
		
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
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda1 = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		Venda venda2 = new Venda(data321, (float)25, itens1, "Pix", 2);
		
		GerenciarVenda.adicionarVenda(venda1);
		GerenciarVenda.adicionarVenda(venda2);
		
		List<Venda>vendas = GerenciarVenda.getVendas();
		
		assertSame(2, vendas.size()); 
		
		assertEquals(venda1, vendas.get(0));
		
		GerenciarVenda.excluirVenda(0); 
		
		assertSame(1, vendas.size()); 
		
		assertEquals(venda2, vendas.get(0));
		
		GerenciarVenda.excluirVenda(1); 
		
		assertSame(0, vendas.size());
		
		GerenciarVenda.setIdVendas(0);
		GerenciarVenda.setVendas(vendasVazia);
	}
}

