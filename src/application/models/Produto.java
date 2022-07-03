package application.models;

import java.util.Calendar;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 11/05/2002
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/
/**
 * Classe para cria��o de Produto
 * 
 * @author Antonio Nicassio
 *
 */
public class Produto {
	/**
	 * Atributos da classe Produto
	 */
	private int id;
	private float preco;
	private Calendar validade;
	private String nome;
	private double quantidade;

	/**
	 * Construtor para o objeto Produto, que � feito sem a passagem do id tendo pr�
	 * setado o id como -1, que ser� modificado ao ser adicionado no gerenciador de
	 * vendas
	 * 
	 * @param preco
	 * @param validade
	 * @param nome
	 * @param quantidade
	 */
	public Produto(float preco, Calendar validade, String nome, double quantidade) {
		this.id = -1;
		this.preco = preco;
		this.validade = validade;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	/**
	 * get id do Produto
	 * 
	 * @return id do produto
	 */
	public int getIdProduto() {
		return this.id;
	}

	/**
	 * get do pre�o do produto
	 * 
	 * @return pre�o do produto
	 */
	public float getPrecoProduto() {
		return this.preco;
	}

	/**
	 * get da validade do produto
	 * 
	 * @return validade do produto
	 */
	public Calendar getValidade() {
		return this.validade;
	}

	/**
	 * get do nome do produto
	 * 
	 * @return nome do produto
	 */
	public String getNomeProduto() {
		return this.nome;
	}

	/**
	 * get da quantidade do produto
	 * 
	 * @return quantidade do produto
	 */
	public double getQuantidadeProduto() {
		return this.quantidade;
	}

	/**
	 * set do id do produto
	 * 
	 * @param id
	 */
	public void setIdProduto(int id) {
		this.id = id;
	}

	/**
	 * set do pre�o do produto
	 * 
	 * @param preco
	 */
	public void setPrecoProduto(float preco) {
		this.preco = preco;
	}

	/**
	 * set da validade do produto
	 * 
	 * @param validade
	 */
	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	/**
	 * set do nome do produto
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * set da quantiade do produto
	 * 
	 * @param quantidade
	 */
	public void setQuantidadeProduto(double quantidade) {
		this.quantidade = quantidade;
	}
}
