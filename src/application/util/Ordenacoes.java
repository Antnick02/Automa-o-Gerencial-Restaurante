package application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import application.models.Fornecedor;
import application.models.GerenciarFornecedor;
import application.models.GerenciarVenda;
import application.models.Produto;
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
public class Ordenacoes {

	/**
	 * Fun��o respons�vel por ordernar os produtos por quantidade
	 * 
	 * @param produtos
	 * @return produtos1
	 */
	public static List<Produto> OrdenarProdutosQuantidade(List<Produto> produtos) {

		List<Produto> produtos1 = new ArrayList<>(produtos);
		Produto maior;
		int i;
		int j;

		for (j = 1; j < produtos1.size(); j++) {
			maior = produtos1.get(j);
			for (i = j - 1; (i >= 0) && (produtos1.get(i).getQuantidadeProduto() < maior.getQuantidadeProduto()); i--) {
				produtos1.set(i + 1, produtos1.get(i));
			}
			produtos1.set(i + 1, maior);
		}

		return produtos1;

	}

	/**
	 * Fun��o respons�vel por ordernar os produtos por vencimento
	 * 
	 * @param produtos
	 * @return produtos1
	 * @throws ParseException 
	 */
	public static List<Produto> OrdenarProdutosVencimento(List<Produto> produtos) throws ParseException {

		List<Produto> produtos1 = new ArrayList<>(produtos);
		Produto menor;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy"); 
		
		int i;
		int j;

		for (j = 1; j < produtos1.size(); j++) {
			menor = produtos1.get(j);
			for (i = j - 1; (i >= 0) && ((s.parse(produtos1.get(i).getValidade())).after((s.parse(menor.getValidade())))); i--) {
				produtos1.set(i + 1, produtos1.get(i));
			}
			produtos1.set(i + 1, menor);
		}

		return produtos1;

	} 
	
	/**
	 * Fun��o respons�vel por ordernar as vendas pela menor data
	 * 
	 * @param vendas
	 * @return vendas1
	 * @throws ParseException 
	 */
	public static List<Venda> OrdenarVendasData(List<Venda> vendas) throws ParseException {

		List<Venda> vendas1 = new ArrayList<>(vendas);
		Venda menor;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy"); 
		
		int i;
		int j;

		for (j = 1; j < vendas1.size(); j++) {
			menor = vendas1.get(j);
			for (i = j - 1; (i >= 0) && ((s.parse(vendas1.get(i).getData())).after((s.parse(menor.getData())))); i--) {
				vendas1.set(i + 1, vendas1.get(i));
			}
			vendas1.set(i + 1, menor);
		}

		return vendas1;

	}
	
	
	/**
	 * Fun��o respons�vel por receber um id de um produto e 
	 * retornar uma lista de fornecedores que cont�m este produto
	 * @param id
	 * @return
	 */
	public static List<Fornecedor> OrdenarFornecedorProduto(int id){ 
		
		List<Fornecedor>fornecedores = new ArrayList<>(); 
		
		for(Fornecedor fornecedor : GerenciarFornecedor.getFornecedores()) {
			
			for(Integer i : fornecedor.getProdutos()) {
					
				if(i.equals(id)) {
					
					fornecedores.add(fornecedor);
					
				}
				
			}
			
		}
		
		return fornecedores;
		
	} 
	
	/**
	 * Fun��o respons�vel por receber um id de um prato e 
	 * retornar uma lista de vendas que cont�m este prato
	 * @param id
	 * @return
	 */
	public static List<Venda> OrdenarVendaPrato(int id){ 
		
		List<Venda>vendas = new ArrayList<>(); 
		
		for(Venda venda : GerenciarVenda.getVendas()) {
			
			for(Integer i : venda.getItens()) {
					
				if(i.equals(id)) {
					
					vendas.add(venda);
					
				}
				
			}
			
		}
		
		return vendas;
		
	}
	

}
