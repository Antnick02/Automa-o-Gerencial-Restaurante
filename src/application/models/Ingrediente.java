package application.models;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 11/05/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/

/**
 * Classe criada com objetivo de integrar a classe Prato para melhor facilita��o
 * no processo de manusear os dados durante o programa
 * 
 * @author anton
 *
 */
public class Ingrediente {
	/**
	 * Atributos da classe
	 */
	private int idProduto;
	private double quantidadeProduto;

	/**
	 * Construtor da classe
	 * 
	 * @param idProduto
	 * @param quantidade
	 */
	public Ingrediente(int idProduto, double quantidade) {
		this.idProduto = idProduto;
		this.quantidadeProduto = quantidade;
	}

	/**
	 * get id do produto
	 * 
	 * @return id produtp
	 */
	public int getIdProduto() {
		return this.idProduto;
	}

	/**
	 * get quantidade do produto
	 * 
	 * @return quantidade produto
	 */
	public double getQuantidade() {
		return this.quantidadeProduto;
	}

	/**
	 * set id do produto do ingrediente
	 * 
	 * @param id
	 */
	public void setIdProduto(int id) {
		this.idProduto = id;
	}

	/**
	 * set da quantidade do produto do ingrediente
	 * 
	 * @param quantidade
	 */
	public void setQuantidadeProduto(double quantidade) {
		this.quantidadeProduto = quantidade;
	}
}
