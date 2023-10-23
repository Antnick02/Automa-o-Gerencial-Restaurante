package application.util;

import java.util.List;

import application.models.GerenciarPrato;
import application.models.Prato;
import application.models.Venda;
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
public class Calcula {
	
	/**
	 * Fun��o que calcula o pre�o total de todos os itens da lista de id's de itens
	 * passada
	 * 
	 * @param itens
	 * @return pre�o Total
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
	 * Fun��o que recebe uma lista de vendas e a quantidade total 
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
	 * Fun��o que recebe uma lista de vendas e retorna 
	 * a soma do pre�o de todas elas
	 * @param vendas
	 * @return pre�o total das vendas
	 */
	public static float calculaPrecoVendas(List<Venda>vendas) {
		
		float precoTotal = 0; 
		
		for(Venda venda : vendas) {
			precoTotal = precoTotal + venda.getPrecoTotal();
		}
		
		return precoTotal;
		
	}
}
