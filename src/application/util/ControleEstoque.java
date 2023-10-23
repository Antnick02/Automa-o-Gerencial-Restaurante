package application.util;

import java.util.List;

import application.models.GerenciarPrato;
import application.models.GerenciarProduto;
import application.models.Ingrediente;
import application.models.Prato;
import application.models.Produto;

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
public class ControleEstoque {
	
	/**
	 * Função que reduz do estoque as quantidades dos produtos utilizadas
	 * para criação do prato
	 * @param id
	 */
	public static void reduzEstoque(int id) {
		
		int posicao; 
		int idProduto;
		double quantidade;
		double quantidadeProduto;
		
		posicao = GerenciarPrato.buscaPrato(id, GerenciarPrato.getPratos(), GerenciarPrato.getPratos().size());
		Prato prato = GerenciarPrato.getPratos().get(posicao); 
		for(Ingrediente ingrediente : prato.getComposicao()) {
			idProduto = ingrediente.getIdProduto();			
			for(Produto produto : GerenciarProduto.getProdutos()) {
				if(produto.getIdProduto() == idProduto) {
					quantidade = ingrediente.getQuantidade(); 
					if(quantidade <= produto.getQuantidadeProduto()) {
						quantidadeProduto = produto.getQuantidadeProduto() - quantidade;
						produto.setQuantidadeProduto(quantidadeProduto);							
					}
				}
			}
		} 
	} 
	
	/**
	 * Função que adiciona ao estoque as quantidades dos produtos utilizadas
	 * para criação do prato
	 * @param id
	 */
	public static void adicionaEstoqueExclusaoIdItens(int id) {
		
		int posicao; 
		int idProduto;
		double quantidade;
		double quantidadeProduto;
		
		posicao = GerenciarPrato.buscaPrato(id, GerenciarPrato.getPratos(), GerenciarPrato.getPratos().size());
		Prato prato = GerenciarPrato.getPratos().get(posicao); 
		for(Ingrediente ingrediente : prato.getComposicao()) {
			idProduto = ingrediente.getIdProduto();			
			for(Produto produto : GerenciarProduto.getProdutos()) {
				if(produto.getIdProduto() == idProduto) {
					quantidade = ingrediente.getQuantidade(); 
					quantidadeProduto = produto.getQuantidadeProduto() + quantidade;
					produto.setQuantidadeProduto(quantidadeProduto);							
				}
			}
		}
	} 
	
	/**
	 * Função responsável por verificar se a quantidade de produtos no estoque 
	 * é o suficiente para confecção dos e reduz essa quantidade necessária 
	 * do estoque 
	 * @param pratos
	 * @return true ou false
	 */
	public static boolean verificaReducaoEstoque(List<Integer>pratos) {
		
		boolean suficiente = false; 
		int posicao = 0; 
		
		for(Integer i : pratos) { 
			
			if(Verificacoes.verificaReducao(i)) {
				suficiente = true; 
				reduzEstoque(i);
				posicao++;
			}else {
				for(int j = 0 ; j < posicao; j++) {
					adicionaEstoqueExclusaoIdItens(pratos.get(j));
					suficiente = false;
				} 
				break;
			}
			
		} 
		
		return suficiente;
		
	}
	
	
	
	
	
	
	
	
}
