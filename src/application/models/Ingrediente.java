package application.models;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 11/05/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/

/**
 * Classe criada com objetivo de integrar a classe Prato para melhor facilitação
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
