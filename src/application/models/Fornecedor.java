package application.models;

import java.util.List;
import java.util.ArrayList;

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
 * Classe para cria��o de Fornecedor
 * 
 * @author Antonio Nicassio
 *
 */

public class Fornecedor {
	/**
	 * Atributos da classe cliente
	 */
	private int cnpj;
	private String nome;
	private int id;
	private String endereco;
	private List<Integer> produtos = new ArrayList<>();

	/**
	 * Construtor para o objeto Fornecedor, que � feito sem a passagem do id tendo
	 * pr� setado o id como -1, que ser� modificado ao ser adicionado no gerenciador
	 * de fornecedores
	 * 
	 * @param nome
	 * @param cnpj
	 * @param endereco
	 * @param produtos
	 */
	public Fornecedor(String nome, int cnpj, String endereco, List<Integer> produtos) {
		this.id = -1;
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.produtos = produtos;
	}

	/**
	 * get id do fornecedor
	 * 
	 * @return id do fornecedor
	 */
	public int getIdFornecedor() {
		return this.id;
	}

	/**
	 * get nome do fornecedor
	 * 
	 * @return nome do fornecedor
	 */
	public String getNomeFornecedor() {
		return this.nome;
	}

	/**
	 * get cnpj do fornecedor
	 * 
	 * @return cnpj fornecedor
	 */
	public int getCnpj() {
		return this.cnpj;
	}

	/**
	 * get endere�o do fornecedor
	 * 
	 * @return endere�o fornecedor
	 */
	public String getEndereco() {
		return this.endereco;
	}

	/**
	 * get lista de id de produtos do fornecedor
	 * 
	 * @return lista de id de produtos de fornecedores
	 */
	public List<Integer> getProdutos() {
		return this.produtos;
	}

	/**
	 * set id do fornecedor
	 * 
	 * @param id
	 */
	public void setIdFornecedor(int id) {
		this.id = id;
	}

	/**
	 * set nomed do fornecedor
	 * 
	 * @param nome
	 */
	public void setNomeFornecedor(String nome) {
		this.nome = nome;
	}

	/**
	 * set cnpj fornecedor
	 * 
	 * @param cnpj
	 */
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * set endere�o do fornecedor
	 * 
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * set produtos do fornecedor
	 * 
	 * @param produtos
	 */
	public void setProdutos(List<Integer> produtos) {
		this.produtos = produtos;
	}
}
