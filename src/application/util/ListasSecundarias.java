package application.util;

import java.util.ArrayList;
import java.util.List;

import application.models.Fornecedor;
import application.models.GerenciarPrato;
import application.models.GerenciarProduto;
import application.models.Prato;
import application.models.Produto;
import application.models.Venda;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/ 
public class ListasSecundarias {

	/**
	 * Função que recebe um fornecedor e retorna uma lista de objetos do produto do
	 * fornecedor
	 * 
	 * @param fornecedor
	 * @return produtos fornecedore
	 */
	public static List<Produto> listaFornecedorProdutos(Fornecedor fornecedor) {

		List<Produto> produtosGerenciamento = GerenciarProduto.getProdutos();
		List<Integer> produtosFornecedor = fornecedor.getProdutos();
		List<Produto> produtosFornecedorObj = new ArrayList<>();

		for (Integer i : produtosFornecedor) {

			for (Produto produto : produtosGerenciamento) {

				if (i.equals(produto.getIdProduto())) {

					produtosFornecedorObj.add(produto);

				}

			}
		}

		return produtosFornecedorObj;
	} 
	
	/**
	 * Função que recebe uma Venda e retorna uma lista de objetos de pratos da
	 * venda
	 * 
	 * @param venda
	 * @return pratos venda
	 */
	public static List<Prato> listaPratoVenda(Venda venda) {

		List<Prato> pratosGerenciamento = GerenciarPrato.getPratos();
		List<Integer> pratosVenda = venda.getItens();
		List<Prato> pratosVendaObj = new ArrayList<>();

		for (Integer i : pratosVenda) {

			for (Prato prato : pratosGerenciamento) {

				if (i.equals(prato.getIdPrato())) {

					pratosVendaObj.add(prato);

				}

			}
		}

		return pratosVendaObj;
	}
	

	/**
	 * Função que recebe uma lista de id's de produtos e retorna uma lista de objetos
	 * do produto do fornecedor
	 * 
	 * @param ids produtos fornecedor
	 * @return produtos fornecedor
	 */
	public static List<Produto> listaProdutosFornecedor(List<Integer> produtosFornecedor) {

		List<Produto> produtosGerenciamento = GerenciarProduto.getProdutos();
		List<Produto> produtosFornecedorObj = new ArrayList<>();

		for (Integer i : produtosFornecedor) {

			for (Produto produto : produtosGerenciamento) {

				if (i.equals(produto.getIdProduto())) {

					produtosFornecedorObj.add(produto);

				}

			}
		}

		return produtosFornecedorObj;
	}   
	
	
	/**
	 * Função que recebe uma lista de id's de pratos e retorna uma lista de objetos
	 * de pratos da venda
	 * 
	 * @param ids pratos venda
	 * @return pratos venda
	 */
	public static List<Prato> listaPratosVenda(List<Integer> pratosVenda) {

		List<Prato> pratosGerenciamento = GerenciarPrato.getPratos();
		List<Prato> pratosVendaObj = new ArrayList<>();

		for (Integer i : pratosVenda) {

			for (Prato prato : pratosGerenciamento) {

				if (i.equals(prato.getIdPrato())) {

					pratosVendaObj.add(prato);

				}

			}
		}

		return pratosVendaObj;
	}  
	

	/**
	 * Função responsável por receber uma lista de pratos e retorna uma lista de
	 * inteiros com os ids desses pratos
	 * 
	 * @param pratos
	 * @return ids pratos
	 */
	public static List<Integer> listaVendaPratosId(List<Prato> pratos) {
		
		List<Integer> pratosVenda = new ArrayList<>();
		if (pratos != null) {
			for (Prato prato : pratos) {

				pratosVenda.add(prato.getIdPrato());

			}
		}
		return pratosVenda;

	} 
	
	/**
	 * Função respnsável por receber uma lista de produtos e retorna uma lista de
	 * inteiros com os ids desses produtos
	 * 
	 * @param produtos
	 * @return ids produtos
	 */
	public static List<Integer> listaProdutosFornecedorId(List<Produto> produtos) {
		
		List<Integer> produtosFornecedor = new ArrayList<>();
		if (produtos != null) {
			for (Produto produto : produtos) {

				produtosFornecedor.add(produto.getIdProduto());

			}
		}
		return produtosFornecedor;

	} 
}
