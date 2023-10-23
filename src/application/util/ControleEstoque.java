package application.util;

import java.util.List;

import application.models.GerenciarPrato;
import application.models.GerenciarProduto;
import application.models.Ingrediente;
import application.models.Prato;
import application.models.Produto;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 09/07/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/ 
public class ControleEstoque {
	
	/**
	 * Fun��o que reduz do estoque as quantidades dos produtos utilizadas
	 * para cria��o do prato
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
	 * Fun��o que adiciona ao estoque as quantidades dos produtos utilizadas
	 * para cria��o do prato
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
	 * Fun��o respons�vel por verificar se a quantidade de produtos no estoque 
	 * � o suficiente para confec��o dos e reduz essa quantidade necess�ria 
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
