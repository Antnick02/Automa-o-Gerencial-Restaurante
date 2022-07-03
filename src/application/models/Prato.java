package application.models;

import java.util.List;
import java.util.ArrayList;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 10/04/2002
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/
/**
 * Classe para cria��o de Prato
 * 
 * @author Antonio Nicassio
 *
 */
public class Prato {
	/**
	 * Atributos da classe Prato
	 */
	private int id;
	private String nome;
	private String categoria;
	private String descricao;
	private float preco;
	private List<Ingrediente> composicao = new ArrayList<>();

	/**
	 * Construtor para o objeto Prato, que � feito sem a passagem do id tendo pr�
	 * setado o id como -1, que ser� modificado ao ser adicionado no gerenciador de
	 * pratos
	 * 
	 * @param nome
	 * @param categoria
	 * @param descricao
	 * @param composicao
	 * @param preco
	 */
	public Prato(String nome, String categoria, String descricao, List<Ingrediente> composicao, float preco) {
		this.id = -1;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
		this.composicao = composicao;
	}

	/**
	 * get id de prato
	 * 
	 * @return id do prato
	 */
	public int getIdPrato() {
		return this.id;
	}

	/**
	 * get nome de prato
	 * 
	 * @return nome de prato
	 */
	public String getNomePrato() {
		return this.nome;
	}

	/**
	 * get descri��o do prato
	 * 
	 * @return descri��o do prato
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * get categoria do prato
	 * 
	 * @return categoria do prato
	 */
	public String getCategoria() {
		return this.categoria;
	}

	/**
	 * get pre�o do prato
	 * 
	 * @return pre�o do prato
	 */
	public float getPrecoPrato() {
		return this.preco;
	}

	/**
	 * get lista de ingredientes da composi��o do prato
	 * 
	 * @return lista de ingredientes da composi��o do prato
	 */
	public List<Ingrediente> getComposicao() {
		return this.composicao;
	}

	/**
	 * set id do prato
	 * 
	 * @param id
	 */
	public void setIdPrato(int id) {
		this.id = id;
	}

	/**
	 * set nome do prato
	 * 
	 * @param nome
	 */
	public void setNomePrato(String nome) {
		this.nome = nome;
	}

	/**
	 * set categoria do prato
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * set pre�o do prato
	 * 
	 * @param preco
	 */
	public void setPrecoPrato(float preco) {
		this.preco = preco;
	}

	/**
	 * set da composi��o do prato
	 * 
	 * @param composicao
	 */
	public void setComposicao(List<Ingrediente> composicao) {
		this.composicao = composicao;
	}
}
