package application.models;
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
public class Cliente {
	/**
	 * Atributos da classe Cliente
	 */
	private int id;
	private String nome;
	private int cpf;
	private String email;
	private int telefone;

	/**
	 * Construtor para o objeto Cliente, que é feito sem a passagem do id tendo pré
	 * setado o id como -1, que será modificado ao ser adicionado no gerenciador de
	 * clientes
	 * 
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param telefone
	 */
	public Cliente(String nome, int cpf, String email, int telefone) {
		this.id = -1;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * função get id cliente
	 * 
	 * @return id
	 */
	public int getIdCliente() {
		return this.id;
	}

	/**
	 * função get nome do cliente
	 * 
	 * @return nome
	 */
	public String getNomeCliente() {
		return this.nome;
	}

	/**
	 * função get cpf do cliente
	 * 
	 * @return cpf
	 */
	public int getCpf() {
		return this.cpf;
	}

	/**
	 * função get email do cliente
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * função get telefone do cliente
	 * 
	 * @return telefone
	 */
	public int getTelefone() {
		return this.telefone;
	}

	/**
	 * função set do id do cliente
	 * 
	 * @param id
	 */
	public void setIdCliente(int id) {
		this.id = id;
	}

	/**
	 * função set do nome do cliente
	 * 
	 * @param nome
	 */
	public void setNomeCliente(String nome) {
		this.nome = nome;
	}

	/**
	 * função set cpf do cliente
	 * 
	 * @param cpf
	 */
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	/**
	 * função set do email do cliente
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * função set do telefone do cliente
	 * 
	 * @param telefone
	 */
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
