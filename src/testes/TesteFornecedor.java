package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import application.models.Fornecedor;
import application.models.GerenciarFornecedor;

class TesteFornecedor {

	@Test
	void testeConstrutorFornecedor() {
		
		List<Integer>produtos = new ArrayList<>(); 
		List<Integer>produtos1 = new ArrayList<>();
		
		produtos.add(1);
		produtos.add(2);
		produtos.add(3);
		
		Fornecedor fornecedor = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos);
		
		assertEquals(fornecedor, fornecedor);
		
		Fornecedor fornecedor2 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1); 
		
		assertEquals(fornecedor2, fornecedor2);
		
		
	}
	
	@Test 
	void testeCriacaoGerenciarFornecedor() {
		
		assertSame(0, GerenciarFornecedor.getFornecedores().size()); 
		assertSame(0, GerenciarFornecedor.getIdFornecedores());
	}
	
	
	@Test 
	void testeAdicionarFornecedor() {
		
		List<Fornecedor> fornecedoresVazia = new ArrayList<>();
		
		List<Integer>produtos1 = new ArrayList<>(); 
		
		produtos1.add(1);
		produtos1.add(2);
		produtos1.add(3);
		
		List<Integer>produtos2 = new ArrayList<>(); 
		
		produtos2.add(3);
		produtos2.add(2);
		produtos2.add(1);
		
		Fornecedor fornecedor1 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1);
		Fornecedor fornecedor2 = new Fornecedor("Palmeira", 321, "Rua 2", produtos2); 
		
		assertSame(0, GerenciarFornecedor.getFornecedores().size()); 
		assertSame(0, GerenciarFornecedor.getIdFornecedores()); 
		
		GerenciarFornecedor.adicionarFornecedor(fornecedor1);
		
		assertSame(1, GerenciarFornecedor.getFornecedores().size()); 
		assertSame(1, GerenciarFornecedor.getIdFornecedores());
		
		GerenciarFornecedor.adicionarFornecedor(fornecedor2);
		
		assertSame(2, GerenciarFornecedor.getFornecedores().size()); 
		assertSame(2, GerenciarFornecedor.getIdFornecedores()); 
		
		GerenciarFornecedor.setFornecedores(fornecedoresVazia);
		GerenciarFornecedor.setIdFornecedores(0);
	}
	
	@Test 
	void testeExcluirFornecedor() {
		
		List<Fornecedor> fornecedoresVazia = new ArrayList<>();
		
		List<Integer>produtos1 = new ArrayList<>(); 
		
		produtos1.add(1);
		produtos1.add(2);
		produtos1.add(3);
		
		List<Integer>produtos2 = new ArrayList<>(); 
		
		produtos2.add(3);
		produtos2.add(2);
		produtos2.add(1);
		
		Fornecedor fornecedor1 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1);
		Fornecedor fornecedor2 = new Fornecedor("Palmeira", 321, "Rua 2", produtos2);
		
		GerenciarFornecedor.adicionarFornecedor(fornecedor1);
		GerenciarFornecedor.adicionarFornecedor(fornecedor2); 
		
		List<Fornecedor>fornecedores = GerenciarFornecedor.getFornecedores();
		
		assertSame(2, fornecedores.size()); 
		
		GerenciarFornecedor.excluirFornecedor(0);
		
		assertSame(1, fornecedores.size());
		
		GerenciarFornecedor.excluirFornecedor(1);
		
		assertSame(0, fornecedores.size());
		
		GerenciarFornecedor.setFornecedores(fornecedoresVazia);
		GerenciarFornecedor.setIdFornecedores(0);
	}
	
	@Test 
	void testeEditarFornecedor() {
		
		List<Fornecedor> fornecedoresVazia = new ArrayList<>();
		
		List<Integer>produtos1 = new ArrayList<>(); 
		
		produtos1.add(1);
		produtos1.add(2);
		produtos1.add(3);
		
		List<Integer>produtos2 = new ArrayList<>(); 
		
		produtos2.add(3);
		produtos2.add(2);
		produtos2.add(1);
		
		Fornecedor fornecedor1 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1);
		Fornecedor fornecedor2 = new Fornecedor("Palmeira", 321, "Rua 2", produtos2);
		fornecedor2.setIdFornecedor(0);
		
		GerenciarFornecedor.adicionarFornecedor(fornecedor1);
		
		List<Fornecedor>fornecedores = GerenciarFornecedor.getFornecedores(); 
		
		assertEquals(fornecedor1, fornecedores.get(0)); 
		
		GerenciarFornecedor.editarFornecedor(fornecedor2);
		
		assertEquals(fornecedor2, fornecedores.get(0));
		
		GerenciarFornecedor.setFornecedores(fornecedoresVazia);
		GerenciarFornecedor.setIdFornecedores(0);
	}
	
	@Test 
	void testeListagemFornecedores(){
		
		List<Fornecedor> fornecedoresVazia = new ArrayList<>();
		
		List<Integer>produtos1 = new ArrayList<>(); 
		
		produtos1.add(1);
		produtos1.add(2);
		produtos1.add(3);
		
		List<Integer>produtos2 = new ArrayList<>(); 
		
		produtos2.add(3);
		produtos2.add(2);
		produtos2.add(1);
		
		Fornecedor fornecedor1 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1);
		Fornecedor fornecedor2 = new Fornecedor("Palmeira", 321, "Rua 2", produtos2); 
		
		GerenciarFornecedor.adicionarFornecedor(fornecedor1);
		GerenciarFornecedor.adicionarFornecedor(fornecedor2);
	
		List<Fornecedor>fornecedores = GerenciarFornecedor.getFornecedores(); 
		
		assertSame(2, fornecedores.size()); 
		
		assertEquals(fornecedor1, fornecedores.get(0)); 
	
		GerenciarFornecedor.excluirFornecedor(0);
		
		assertSame(1, fornecedores.size()); 
		
		assertEquals(fornecedor2, fornecedores.get(0));
		
		GerenciarFornecedor.excluirFornecedor(1);
		
		assertSame(0, fornecedores.size());
		
		GerenciarFornecedor.setFornecedores(fornecedoresVazia);
		GerenciarFornecedor.setIdFornecedores(0);
	} 
}
