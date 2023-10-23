package application.util;

import java.util.List;

import application.models.GerenciarPrato;
import application.models.Prato;
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
public class Calcula {
	
	/**
	 * Função que calcula o preço total de todos os itens da lista de id's de itens
	 * passada
	 * 
	 * @param itens
	 * @return preço Total
	 */
	public static float calculaPrecoTotal(List<Integer> itens) {

		float precoTotal = 0;

		for (int id : itens) {
			for (Prato prato : GerenciarPrato.getPratos()) {
				if (id == prato.getIdPrato()) {
					precoTotal = precoTotal + prato.getPrecoPrato();
				}
			}
		}

		return precoTotal;
	} 
	
	/**
	 * Função que recebe uma lista de vendas e a quantidade total 
	 * de pratos existentes dentro das vendas
	 * @param vendas
	 * @return quantidade pratos
	 */
	public static int calculaPratosVendas(List<Venda>vendas) {
		
		int quantidade = 0; 
		
		for(Venda venda : vendas) {
			for(int id : venda.getItens()) {
				quantidade++;
			}
		}
		
		return quantidade;
	} 
	
	/**
	 * Função que recebe uma lista de vendas e retorna 
	 * a soma do preço de todas elas
	 * @param vendas
	 * @return preço total das vendas
	 */
	public static float calculaPrecoVendas(List<Venda>vendas) {
		
		float precoTotal = 0; 
		
		for(Venda venda : vendas) {
			precoTotal = precoTotal + venda.getPrecoTotal();
		}
		
		return precoTotal;
		
	}
}
