package application.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 10/04/2002
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
/**
 * Classe para criação da venda
 * 
 * @author Antonio Nicassio
 *
 */
public class Venda {
	/**
	 * Atributos da classe cliente
	 */
	private float precoTotal;
	private Calendar data;
	private List<Integer> itens = new ArrayList<>();
	private String formaDePagamento;
	private int id;

	/**
	 * Construtor para o objeto Venda, que é feito sem a passagem do id tendo pré
	 * setado o id como -1, que será modificado ao ser adicionado no gerenciador de
	 * vendas
	 * 
	 * @param data
	 * @param precoTotal
	 * @param itens
	 * @param formaDePagamento
	 */
	public Venda(Calendar data, float precoTotal, List<Integer> itens, String formaDePagamento) {
		this.data = data;
		this.precoTotal = precoTotal;
		this.itens = itens;
		this.formaDePagamento = formaDePagamento;
		this.id = -1;
	}

	/**
	 * get id da venda
	 * 
	 * @return id da venda
	 */
	public int getIdVenda() {
		return this.id;
	}

	/**
	 * get data da venda
	 * 
	 * @return data da venda
	 */
	public Calendar getData() {
		return this.data;
	}

	/**
	 * get do preço total da venda
	 * 
	 * @return preço total da venda
	 */
	public float getPrecoTotal() {
		return this.precoTotal;
	}

	/**
	 * get da lista de id de itens
	 * 
	 * @return lista de id de itens
	 */
	public List<Integer> getItens() {
		return this.itens;
	}

	/**
	 * get da forma de pagamento da venda
	 * 
	 * @return forma de pagamento da venda
	 */
	public String getFormaDePagamento() {
		return this.formaDePagamento;
	}

	/**
	 * set do id da venda
	 * 
	 * @param id
	 */
	public void setIdVenda(int id) {
		this.id = id;
	}

	/**
	 * set do preço total da venda
	 * 
	 * @param preco
	 */
	public void setPrecoTotal(float preco) {
		this.precoTotal = preco;
	}

	/**
	 * set da lista de id de itens da venda
	 * 
	 * @param itens
	 */
	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}

	/**
	 * set da forma de pagamento da venda
	 * 
	 * @param formaDePagamento
	 */
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
}
